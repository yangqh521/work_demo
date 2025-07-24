package com.yqh.demo.vaild.validator;

import com.yqh.demo.vaild.model.OrderContext;

// 校验器接口（移除持久化方法）
public interface Validator {
    // 校验优先级
    int getOrder();

    // 是否支持当前场景
    boolean support(OrderContext context);

    // 执行校验
    boolean validate(OrderContext context);

}