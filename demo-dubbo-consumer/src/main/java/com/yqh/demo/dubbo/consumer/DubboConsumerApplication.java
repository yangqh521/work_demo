package com.yqh.demo.dubbo.consumer;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.yqh.demo.dubbo.base.DubboBaseAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

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
@Import(DubboBaseAutoConfiguration.class)
public class DubboConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerApplication.class, args);
    }
}
