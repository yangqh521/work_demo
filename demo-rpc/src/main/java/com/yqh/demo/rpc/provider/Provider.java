package com.yqh.demo.rpc.provider;

import com.yqh.demo.rpc.framework.URL;
import com.yqh.demo.rpc.protocol.http.HttpServer;
import com.yqh.demo.rpc.provider.api.IHelloApiService;
import com.yqh.demo.rpc.provider.impl.HelloApiServiceImpl;
import com.yqh.demo.rpc.register.LocalRegister;
import com.yqh.demo.rpc.register.RemoteMapRegister;
import java.io.IOException;

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
        HttpServer server = new HttpServer();
        server.start("localhost", 8080);
    }

}
