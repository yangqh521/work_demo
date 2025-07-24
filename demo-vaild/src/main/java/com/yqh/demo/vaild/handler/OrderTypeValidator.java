package com.yqh.demo.vaild.handler;

import com.yqh.demo.vaild.model.OrderContext;

// 示例：运单类型校验器
public class OrderTypeValidator extends BaseHandler {

    private final int requiredType;

    public OrderTypeValidator(int requiredType) {
        this.requiredType = requiredType;
    }

    @Override
    protected boolean doValidate(OrderContext context) {
        return context.getOrder().getType() == requiredType;
    }

    @Override
    protected void doPersist(OrderContext context) {

    }

    @Override
    public int getOrder() {
        return Integer.MAX_VALUE;
    }

}