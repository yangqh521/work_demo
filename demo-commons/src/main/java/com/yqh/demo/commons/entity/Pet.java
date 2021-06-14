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
 * @subject 宠物定义类
 * @link
 * @desp
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pet implements Serializable {
    private String name;
}
