package com.yqh.demo.springboot2.config;

import ch.qos.logback.core.db.DBHelper;
import com.yqh.demo.commons.entity.Pet;
import com.yqh.demo.commons.entity.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author yangqh521
 * @version 1.0
 * @date 2021/6/14
 * @subject 自定义bean
 * @link
 * @desp
 */
@Import({User.class, DBHelper.class})
@Configuration
public class MyConfig {

    @Bean
    public User user01() {
        return User.builder().name("yqh").age(27)
                .email("yangqh521@qq.com").address("beijing")
                .pet(pet01())
                .build();
    }

    @Bean("tom")
    public Pet pet01() {
        return Pet.builder().name("tom").build();
    }

    @Bean("lxl")
    public User user02() {
        return User.builder().name("lxl").age(26)
                .email("leexl521@qq.com").address("beijing")
                .build();
    }



}
