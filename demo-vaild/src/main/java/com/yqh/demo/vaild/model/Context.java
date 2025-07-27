package com.yqh.demo.vaild.model;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

// 上下文定义
public class Context extends ConcurrentHashMap<String, Object> {

    public <T> T get(String key, Class<T> type) {
        return type.cast(super.get(key));
    }

    public <T> T computeIfAbsent(String key, Function<String, T> loader) {
        return (T) super.computeIfAbsent(key, k -> loader.apply(k));
    }



}