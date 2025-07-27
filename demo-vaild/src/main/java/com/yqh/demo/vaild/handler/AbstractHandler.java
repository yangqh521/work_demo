package com.yqh.demo.vaild.handler;

import com.yqh.demo.vaild.model.OrderContext;
import com.yqh.demo.vaild.persister.Persister;
import com.yqh.demo.vaild.validator.Validator;

// 抽象处理器（校验+持久化）
public abstract class AbstractHandler implements Validator, Persister {
    // 校验逻辑
    @Override
    public boolean validate(OrderContext context) {
        if(!doValidate(context)) {
            return false;
        }
        // 执行子校验器
        for (Validator validator : getSubValidators()) {
            if(validator.support(context) && !validator.validate(context)){
                return false;
            }
        }
        return true;
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