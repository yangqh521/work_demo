package com.yqh.demo.vaild.validator;

import com.yqh.demo.vaild.model.OrderContext;
import java.util.Collections;
import java.util.List;


// 校验器接口（移除持久化方法）
public interface Validator extends ValidatorRule {

    // 是否支持当前场景
    boolean support(OrderContext context);

    // 执行校验
    @Override
    boolean validate(OrderContext context);

    // 获取子校验器
    default List<Validator> getSubValidators() {
        return Collections.emptyList();
    }


}