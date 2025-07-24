package com.yqh.demo.vaild.service;

import com.yqh.demo.commons.base.CommonResult;
import com.yqh.demo.vaild.handler.OrderTypeValidator;
import com.yqh.demo.vaild.demo1.ValidationEngine;
import com.yqh.demo.vaild.model.OrderContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 使用示例
@Service
public class GrabService1 {

    @Autowired
    private OrderService orderService;
    @Autowired
    private DriverService driverService;
    @Autowired
    private ShipperService shipperService;

    public CommonResult grabOrder(Long orderId, Long driverId) {
        try {
            OrderContext context = createContext(orderId, driverId);

            ValidationEngine engine = new ValidationEngine();
            engine.addValidator(new OrderTypeValidator(1));
//            engine.addValidator(new DriverValidator());
//            engine.addPersister(new OrderUpdater());
//            engine.addPersister(new DriverUpdater());

            boolean result = engine.execute(context);

            if (result && context.isValidationPassed()) {
                return CommonResult.success("抢单成功");
            }
            return CommonResult.fail("校验不通过");
        } catch (Exception e) {
            // 事务回滚处理
            return CommonResult.fail("系统异常");
        }
    }



    private OrderContext createContext(Long orderId, Long driverId) {
        return OrderContext.builder()
                .order(orderService.getOrderById(orderId))
                .driver(driverService.getDriverById(driverId))
                .build();
    }

}