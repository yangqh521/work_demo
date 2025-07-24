package com.yqh.demo.vaild.validator;

import com.yqh.demo.vaild.model.OrderContext;

/**
 * @Author: yangqinghui@cfhy.com
 * @Description:
 * @Date: Created in 18:03 2025/7/24
 * @Modified By:
 */
// 抽象校验器基类
public abstract class AbstractValidator implements Validator {
    @Override
    public int getOrder() {
        return Integer.MAX_VALUE; // 默认最低优先级
    }

    @Override
    public boolean support(OrderContext context) {
        return true; // 默认支持所有场景
    }


}