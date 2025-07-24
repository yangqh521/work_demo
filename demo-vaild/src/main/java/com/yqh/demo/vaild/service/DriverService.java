package com.yqh.demo.vaild.service;

import com.yqh.demo.vaild.model.Driver;
import org.springframework.stereotype.Service;

/**
 * @Author: yangqinghui@cfhy.com
 * @Description:
 * @Date: Created in 17:12 2025/7/24
 * @Modified By:
 */
@Service
public class DriverService {

    public Driver getDriverById(Long id) {
        return Driver.builder().id(id).name("张三").build();
    }

}
