package com.yqh.demo.vaild.anno;

import org.springframework.core.annotation.Order;

import java.lang.annotation.*;

/**
 * @Author: yangqinghui@cfhy.com
 * @Description:
 * @Date: Created in 13:55 2025/7/25
 * @Modified By:
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Order
public @interface ProcessorScan {
    // 适用于校验器和持久化器的通用场景定义
    String[] scenes() default {};

    // 适用于校验器和持久化器的通用顺序定义
    int value() default Integer.MAX_VALUE;

}