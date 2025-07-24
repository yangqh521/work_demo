package com.yqh.demo.vaild.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

// 上下文对象
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderContext {

    private Long orderId;
    private Long driverId;
    private Long shipperId;
    private Map<String, Object> cache = new HashMap<>();


    // 存储基础信息
    private Shipper shipper;
    private Driver driver;
    private Order order;

    // 事务数据容器
    private Map<String, Object> transactionData = new HashMap<>();
    private boolean validationPassed = false;

    public <T> T getFromCache(String key, Supplier<T> loader) {
        return (T) cache.computeIfAbsent(key, k -> loader.get());
    }

    // 提交事务数据
    public void commitData(String key, Object data) {
        transactionData.put(key, data);
    }

}