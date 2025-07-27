package com.yqh.demo.vaild.service;

import com.yqh.demo.vaild.model.Shipper;


public class ShipperService {

    public Shipper getShipperById(Long id) {
        return Shipper.builder().id(id).name("shipper" + id).build();
    }

}
