package com.yqh.demo.dubbo.consumer.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yqh.demo.dubbo.api.IHelloApiService;
import com.yqh.demo.dubbo.consumer.service.IHelloService;
import org.springframework.stereotype.Service;

/**
 * @author yangqh521
 * @version 1.0
 * @date 2021/6/19
 * @subject
 * @link
 * @desp
 */
@Service
public class HelloServiceImpl implements IHelloService {

    @Reference
//    @Reference(url = "dubbo://localhost:20882")
    private IHelloApiService helloApiService;

    @Override
    public String sayHello(String userName) {
        String response = helloApiService.sayHello(userName);
        System.out.println("IHelloService >>> response: " + response);
        return response;
    }

}
