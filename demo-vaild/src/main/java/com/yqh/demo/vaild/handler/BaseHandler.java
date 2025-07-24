package com.yqh.demo.vaild.handler;

import com.yqh.demo.vaild.model.OrderContext;
import com.yqh.demo.vaild.persister.Persister;
import com.yqh.demo.vaild.validator.AbstractValidator;

// 基础校验处理器
public abstract class BaseHandler extends AbstractValidator implements Persister {
    @Override
    public boolean validate(OrderContext context) {
        return doValidate(context);
    }

    protected abstract boolean doValidate(OrderContext context);

    @Override
    public void persist(OrderContext context) {
        doPersist(context);
    }

    protected abstract void doPersist(OrderContext context);

    @Override
    public boolean support(OrderContext context) {
        return true; // 默认都执行
    }

    @Override
    public int getOrder() {
        return 0;
    }


}

