package com.yqh.demo.vaild.service;

import com.yqh.demo.vaild.model.Order;


public class OrderService {

    public Order getOrderById(Long id) {
        return Order.builder().id(id).shipperId(1L).sn("sn").build();
    }

}
