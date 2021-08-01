package com.yqh.demo.commons.enums;

import cn.hutool.core.util.IdUtil;

/**
 * @author yangqh521
 * @version 1.0
 * @date 2021/6/26
 * @subject
 * @link
 * @desp
 */
public enum TraceLogType {
    TRACE_ID, URI, API,
    ;
    public static String getTraceId(){
        return IdUtil.simpleUUID();
    }

}
