package com.yqh.demo.vaild.service;

import com.yqh.demo.vaild.model.Shipper;

/**
 * @Author: yangqinghui@cfhy.com
 * @Description:
 * @Date: Created in 17:12 2025/7/24
 * @Modified By:
 */
public class ShipperService {

    public Shipper getShipperById(Long id) {
        return Shipper.builder()
                .id(id)
                .name("shipper" + id)
                .build();
    }

}
