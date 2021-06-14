package com.yqh.demo.commons.exception;

import lombok.Getter;

/**
 * @author yangqh521
 * @version 1.0
 * @date 2021/6/5
 * @subject base异常, 用于作为其他异常的基类
 * @link
 * @desp
 */
@Getter
public class BaseException extends RuntimeException {

    private String code;
    private String msg;

    public BaseException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public BaseException(String code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

}
