package com.yqh.demo.vaild.service;

import com.yqh.demo.vaild.model.Order;

/**
 * @Author: yangqinghui@cfhy.com
 * @Description:
 * @Date: Created in 17:12 2025/7/24
 * @Modified By:
 */
public class OrderService {

    public Order getOrderById(Long id) {
        return Order.builder().id(id).shipperId(1L).sn("sn").build();
    }

}
