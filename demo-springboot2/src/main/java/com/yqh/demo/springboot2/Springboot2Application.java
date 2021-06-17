package com.yqh.demo.springboot2;

import ch.qos.logback.core.db.DBHelper;
import com.yqh.demo.commons.entity.User;
import com.yqh.demo.springboot2.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;


/**
 * @author yangqh521
 * @version 1.0
 * @date 2021/6/14
 * @subject 学习Springboot2源码专用
 * @link
 * @desp
 */
//@SpringBootApplication
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan("com.yqh.demo.springboot2")
public class Springboot2Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Springboot2Application.class, args);
//        testMyConfig(context);
        testSource(context);
    }

    /**
     * 源码测试
     */
    public static void testSource(ConfigurableApplicationContext context) {
        int beanDefinitionCount = context.getBeanDefinitionCount();
        System.out.println("beanDefinitionCount >>> " + beanDefinitionCount);
    }

    /**
     * 测试配置类
     * @param context
     */
    public static void testMyConfig(ConfigurableApplicationContext context) {

        System.out.println("-----------------------------------------------------------");
        MyConfig myConfig = context.getBean(MyConfig.class);
        MyConfig myConfig01 = context.getBean(MyConfig.class);
        System.out.println("myConfig == myConfig01 >>> " + (myConfig == myConfig01));

        System.out.println("-----------------------------------------------------------");
        String[] userBeanNames = context.getBeanNamesForType(User.class);
        for (String userBeanName : userBeanNames) {
            System.out.println("- userBeanName >>> " + userBeanName);
        }

        System.out.println("-----------------------------------------------------------");
        String[] dbBeanNames = context.getBeanNamesForType(DBHelper.class);
        for (String dbBeanName : dbBeanNames) {
            System.out.println("- dbBeanName >>> " + dbBeanName);
        }

        System.out.println("-----------------------------------------------------------");

    }



}
