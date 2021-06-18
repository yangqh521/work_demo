package com.yqh.demo.rpc.framework;

import com.alibaba.fastjson.JSONObject;
import com.yqh.demo.rpc.protocol.http.HttpClient;
import com.yqh.demo.rpc.register.RemoteMapRegister;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author yangqh521
 * @version 1.0
 * @date 2021/6/18
 * @subject
 * @link
 * @desp
 */
public class ProxyFactory {

    public static <T> T getProxy(final Class interfaceClass){
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                Invocation invocation = new Invocation();
                invocation.setInterfaceName(interfaceClass.getName());
                invocation.setMethodName(method.getName());
                invocation.setParamTypes(method.getParameterTypes());
                invocation.setParams(args);
                System.out.println("getProxy >>> invocation:" + JSONObject.toJSONString(invocation));

                URL url = RemoteMapRegister.loanBanlance(interfaceClass.getName());
                System.out.println("getProxy >>> url:" + JSONObject.toJSONString(url));

                HttpClient httpClient = new HttpClient();

                String response = httpClient.send(url.getHostName(), url.getPort(), invocation);
                System.out.println("getProxy >>> response:" + response);

                return response;
            }
        });
    }

}
