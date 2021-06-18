package com.yqh.demo.rpc.protocol.dubbo;

import com.yqh.demo.rpc.framework.Invocation;
import com.yqh.demo.rpc.framework.Protocol;
import com.yqh.demo.rpc.framework.URL;

/**
 * @author yangqh521
 * @version 1.0
 * @date 2021/6/19
 * @subject
 * @link
 * @desp
 */
public class DubboProtocol implements Protocol {

    @Override
    public void start(URL url) {
    }

    @Override
    public String send(URL url, Invocation invocation) {
        return null;
    }
}