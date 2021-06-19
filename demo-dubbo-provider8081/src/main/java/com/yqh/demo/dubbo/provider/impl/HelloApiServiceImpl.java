package com.yqh.demo.dubbo.provider.impl;

import cn.hutool.core.util.IdUtil;
import com.alibaba.dubbo.config.annotation.Service;
import com.yqh.demo.dubbo.api.IHelloApiService;

/**
 * @author yangqh521
 * @version 1.0
 * @date 2021/6/19
 * @subject
 * @link
 * @desp
 */
@Service
public class HelloApiServiceImpl implements IHelloApiService {

    @Override
    public String sayHello(String userName) {
        String response = "Hello, < " + userName + " > nice to meet you ! " + IdUtil.simpleUUID() + " --- 8081";
        System.out.println("IHelloApiService >>> response: " + response);
        return response;
    }

}
