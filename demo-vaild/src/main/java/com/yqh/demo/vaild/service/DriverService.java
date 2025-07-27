package com.yqh.demo.vaild.service;

import com.yqh.demo.vaild.model.Driver;
import org.springframework.stereotype.Service;


@Service
public class DriverService {

    public Driver getDriverById(Long id) {
        return Driver.builder().id(id).name("张三").build();
    }

}
