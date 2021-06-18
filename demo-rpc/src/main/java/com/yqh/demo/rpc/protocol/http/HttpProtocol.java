package com.yqh.demo.rpc.protocol.http;

import com.yqh.demo.rpc.framework.Invocation;
import com.yqh.demo.rpc.framework.Protocol;
import com.yqh.demo.rpc.framework.URL;

/**
 * @author yangqh521
 * @version 1.0
 * @date 2021/6/18
 * @subject
 * @link
 * @desp
 */
public class HttpProtocol implements Protocol {

    @Override
    public void start(URL url) {
        HttpServer server = new HttpServer();
        server.start(url.getHostName(), url.getPort());
    }

    @Override
    public String send(URL url, Invocation invocation) {
        HttpClient httpClient = new HttpClient();
        return httpClient.send(url.getHostName(), url.getPort(), invocation);
    }

}