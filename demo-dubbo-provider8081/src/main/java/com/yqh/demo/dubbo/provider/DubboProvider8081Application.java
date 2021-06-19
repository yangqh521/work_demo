package com.yqh.demo.dubbo.provider;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yangqh521
 * @version 1.0
 * @date 2021/6/19
 * @subject
 * @link
 * @desp
 */
@EnableDubbo
@SpringBootApplication
public class DubboProvider8081Application {

    public static void main(String[] args) {
        SpringApplication.run(DubboProvider8081Application.class, args);
    }

}
