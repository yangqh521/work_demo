package com.yqh.demo.spring5.demo;

import com.alibaba.fastjson.JSONObject;
import com.yqh.demo.spring5.entity.User;
import org.testng.annotations.Test;

/**
 * @author yangqh521
 * @version 1.0
 * @date 2021/6/14
 * @subject IOC容器
 * @link
 * @desp
 *
 * 1. IOC底层原理
 *      1> 什么是IOC
 *          1 - 控制反转, 把对象创建和对象之间的调用过程, 交给Spring进行管理
 *          2 - 使用IOC目的, 为乐耦合度降低
 *      2> IOC底层原理
 *          1> xml解析, 工厂模式, 反射
 *
 * 2. IOC接口(BeanFactory)
 *
 * 3. IOC操作bean管理(基于xml)
 *
 * 4. IOC操作bean管理(基于注解)
 *
 */
public class BeanTest extends ApplicationContextTest {

    @Override
    String getXMLName() {
        return "bean.xml";
    }

    /**
     * IOC操作bean管理(基于xml)
     */
    @Test
    public void getUserTest() {
        User user = getBean("user");
        System.out.println("user >>>> " + JSONObject.toJSONString(user));
    }

}
