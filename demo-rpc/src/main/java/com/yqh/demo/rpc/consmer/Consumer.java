package com.yqh.demo.rpc.consmer;

import com.yqh.demo.rpc.framework.ProxyFactory;
import com.yqh.demo.rpc.provider.api.IHelloApiService;

/**
 * @author yangqh521
 * @version 1.0
 * @date 2021/6/18
 * @subject 消费者
 * @link
 * @desp
 */
public class Consumer {

    public static void main(String[] args) {
        IHelloApiService proxy = ProxyFactory.getProxy(IHelloApiService.class);
        System.out.println(proxy.sayHello("yangqh521"));
    }

}
