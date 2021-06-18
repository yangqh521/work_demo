package com.yqh.demo.rpc.provider.impl;

import com.yqh.demo.rpc.provider.api.IHelloApiService;

/**
 * @author yangqh521
 * @version 1.0
 * @date 2021/6/18
 * @subject 服务实现
 * @link
 * @desp
 */
public class HelloApiServiceImpl implements IHelloApiService {

    @Override
    public String sayHello(String userName) {
        String response = "Hello, < " + userName + " > nice to meet you !";
        System.out.println("HelloApiServiceImpl >>> response:" + response);
        return response;
    }

}
