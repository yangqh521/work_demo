package com.yqh.demo.vaild.demo1;

import com.yqh.demo.vaild.model.OrderContext;
import com.yqh.demo.vaild.persister.Persister;
import com.yqh.demo.vaild.validator.Validator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// 校验引擎
public class ValidationEngine {

    private List<Validator> validators = new ArrayList<>();
    private List<Persister> persisters = new ArrayList<>();

    public void addValidator(Validator validator) {
        validators.add(validator);
    }

    public void addPersister(Persister persister) {
        persisters.add(persister);
    }

    public boolean execute(OrderContext context) {
        // 阶段一：校验阶段
        validators.sort(Comparator.comparingInt(Validator::getOrder));
        for (Validator validator : validators) {
            if (!validator.support(context)) continue;
            if (!validator.validate(context)) {
                return false;
            }
        }

        // 阶段二：持久化阶段
        persisters.sort(Comparator.comparingInt(Persister::getOrder));
        for (Persister persister : persisters) {
            persister.persist(context);
        }

        context.setValidationPassed(true);
        return true;
    }
}