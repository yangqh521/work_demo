package com.yqh.demo.rpc.protocol.http;

import com.alibaba.fastjson.JSONObject;
import com.yqh.demo.rpc.framework.Invocation;
import com.yqh.demo.rpc.provider.LocalRegister;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.Method;

/**
 * @author yangqh521
 * @version 1.0
 * @date 2021/6/18
 * @subject 请求处理类
 * @link
 * @desp
 */
public class HttpServerHandler {

    public void handler(HttpServletRequest request, HttpServletResponse response){
        try {
            InputStream inputStream = request.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            Invocation invocation = (Invocation) objectInputStream.readObject();
            System.out.println("HttpServerHandler >>> invocation:" + JSONObject.toJSONString(invocation));
            Class calzz = LocalRegister.get(invocation.getInterfaceName());
            Method method = calzz.getMethod(invocation.getMethodName(), invocation.getParamTypes());
            String result = (String) method.invoke(calzz.newInstance(), invocation.getParams());
            System.out.println("HttpServerHandler >>> result:" + result);
            IOUtils.write(result, response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
