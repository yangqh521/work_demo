package com.yqh.demo.vaild.validator;

import com.yqh.demo.vaild.model.OrderContext;

// 抽象校验器基类
public abstract class AbstractValidator implements Validator {

    @Override
    public boolean support(OrderContext context) {
        return true; // 默认支持所有场景
    }



}