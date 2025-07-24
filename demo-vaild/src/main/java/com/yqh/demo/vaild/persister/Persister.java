package com.yqh.demo.vaild.persister;

import com.yqh.demo.vaild.model.OrderContext;

// 持久化接口
public interface Persister {
    int getOrder();
    void persist(OrderContext context);
}
