package com.yqh.demo.vaild.persister;

import com.yqh.demo.vaild.model.OrderContext;

import java.util.Comparator;

// 持久化接口
public interface Persister {

    int getOrder();

    void persist(OrderContext context);

    // 是否支持当前场景
    boolean support(OrderContext context);

}
