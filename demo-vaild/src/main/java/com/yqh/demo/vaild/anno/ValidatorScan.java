package com.yqh.demo.vaild.anno;


import org.springframework.core.annotation.Order;

import java.lang.annotation.*;

/**
 * 定义校验组件适用场景
 */
@Order
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ValidatorScan {

    String[] scenes() default {};

    int value() default Integer.MAX_VALUE;

}
