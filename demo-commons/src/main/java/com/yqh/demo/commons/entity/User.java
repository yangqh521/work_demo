package com.yqh.demo.commons.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

/**
 * @author yangqh521
 * @version 1.0
 * @date 2021/6/14
 * @subject 用户定义类
 * @link
 * @desp
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private String name;
    private Integer age;
    private String email;
    private String address;
}
