package com.yqh.demo.rpc.framework;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yangqh521
 * @version 1.0
 * @date 2021/6/18
 * @subject url
 * @link
 * @desp
 */
@Data
public class URL implements Serializable{
    private String hostName;
    private Integer port;
}
