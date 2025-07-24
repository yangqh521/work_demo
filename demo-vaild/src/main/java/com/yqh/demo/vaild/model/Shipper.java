package com.yqh.demo.vaild.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: yangqinghui@cfhy.com
 * @Description:
 * @Date: Created in 17:12 2025/7/24
 * @Modified By:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Shipper implements Serializable {

    private Long id;

    private String name;

}
