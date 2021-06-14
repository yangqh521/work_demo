package com.yqh.demo.spring5.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yangqh521
 * @version 1.0
 * @date 2021/6/14
 * @subject 抽象获取bean父类
 * @link
 * @desp
 */
public abstract class ApplicationContextTest {

    public ApplicationContext applicationContext;

    public ApplicationContextTest() {
        applicationContext = new ClassPathXmlApplicationContext(getXMLName());
    }

    abstract String getXMLName();

    public <T> T getBean(String beanName) {
        return (T) applicationContext.getBean(beanName);
    }


}
