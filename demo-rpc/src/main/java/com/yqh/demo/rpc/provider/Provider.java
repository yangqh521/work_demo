package com.yqh.demo.rpc.provider;

import com.yqh.demo.rpc.framework.Protocol;
import com.yqh.demo.rpc.framework.ProtocolFactory;
import com.yqh.demo.rpc.framework.URL;
import com.yqh.demo.rpc.provider.api.IHelloApiService;
import com.yqh.demo.rpc.provider.impl.HelloApiServiceImpl;
import com.yqh.demo.rpc.register.RemoteMapRegister;

/**
 * @author yangqh521
 * @version 1.0
 * @date 2021/6/18
 * @subject 提供者
 * @link
 * @desp
 */
public class Provider {

    public static void main(String[] args) {

        // 1、本地注册 {服务名：实现类}
        LocalRegister.regist(IHelloApiService.class.getName(), HelloApiServiceImpl.class);

        // 2、远程注册 {服务名：List<URL>}
        URL url = new URL();
        url.setHostName("localhost");
        url.setPort(8080);
        RemoteMapRegister.register(IHelloApiService.class.getName(), url);

        // 3、启动tomcat
        Protocol protocol = ProtocolFactory.getProtocol();
        protocol.start(url);
    }

}
