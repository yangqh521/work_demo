package com.yqh.demo.vaild.demo1;

import com.yqh.demo.vaild.model.OrderContext;
import com.yqh.demo.vaild.persister.Persister;
import com.yqh.demo.vaild.validator.Validator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: yangqinghui@cfhy.com
 * @Description:
 * @Date: Created in 11:28 2025/7/25
 * @Modified By:
 */
public abstract class AbstractHandlerEngine {

    public abstract List<Validator> getValidators();

    public abstract List<Persister> getPersisters();

    public boolean execute(OrderContext context) {
        // 阶段一：校验阶段
        List<Validator> validators = getValidators();
        for (Validator validator : validators) {
            // 中断
            if (!context.getValidationResult().isSuccess()) {
                return false;
            }
            if (!validator.support(context)) {
                continue;
            }
            if (!validator.validate(context)) {
                return false;
            }
        }
        context.setValidationPassed(true);

        // 阶段二：持久化阶段
        List<Persister> persisters = getPersisters();
        for (Persister persister : persisters) {
            if (persister.support(context)) {
                persister.persist(context);
            }
        }
        return true;
    }


}
