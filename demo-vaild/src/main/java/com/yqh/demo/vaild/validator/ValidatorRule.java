package com.yqh.demo.vaild.validator;

import com.yqh.demo.vaild.model.OrderContext;
import java.util.function.Predicate;
import java.util.function.Supplier;


@FunctionalInterface
public interface ValidatorRule {

    // 执行校验
    boolean validate(OrderContext context);

    default ValidatorRule and(ValidatorRule other) {
        return ctx -> this.validate(ctx) && other.validate(ctx);
    }

    default ValidatorRule or(ValidatorRule other) {
        return ctx -> this.validate(ctx) || other.validate(ctx);
    }

    static ValidatorRule of(Predicate<OrderContext> predicate) {
        return predicate::test;
    }

    static ValidatorRule failFast(Integer errorKey, Supplier<String> errorMsgSupplier) {
        return ctx -> {
            boolean success = false;
            try {
                success = ctx.getValidationResult().isSuccess();
            } catch (Exception e) {
                /* ignore */
            }
            if (!success) {
                ctx.getValidationResult().setError(errorKey, errorMsgSupplier.get());
                return false;
            }
            return true;
        };
    }



}
