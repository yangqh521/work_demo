package com.yqh.demo.vaild.anno;


import org.springframework.core.annotation.Order;
import java.lang.annotation.*;

/**
 * 定义持久化组件适用场景
 */
@Order
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PersisterScan {

    String[] scenes() default {};

    int value() default Integer.MAX_VALUE;

}
