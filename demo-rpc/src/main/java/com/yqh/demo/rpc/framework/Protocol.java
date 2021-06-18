package com.yqh.demo.rpc.framework;

/**
 * @author yangqh521
 * @version 1.0
 * @date 2021/6/18
 * @subject 协议
 * @link
 * @desp
 */
public interface Protocol {

    void start(URL url);

    void send(URL url, Invocation invocation);

}
