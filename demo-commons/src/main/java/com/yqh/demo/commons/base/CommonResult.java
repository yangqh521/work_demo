package com.yqh.demo.commons.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yangqh521
 * @version 1.0
 * @date 2021/5/25
 * @subject 请求返回包装类
 * @link
 * @desp
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> implements Serializable {

    /**
     * code值定义
     */
    public interface CODE {
        int FAIL = 0;
        int SUCCESS = 1;
    }

    private static final String DEFAULT_PORT = "unknown";
    private static final String DEFAULT_SUCCESS_MSG = "请求成功!";
    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    /**
     * 响应码
     */
    private Integer code = CODE.SUCCESS;

    /**
     * 错误信息
     */
    private String msg = DEFAULT_SUCCESS_MSG;

    /**
     * 返回数据
     */
    private T data = null;

    /**
     * 请求端口值
     */
    private String port = DEFAULT_PORT;

    /**
     * 响应时间
     */
    private String time = SDF.format(new Date());

    /**
     * 成功返回
     * @param data
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> success(T data){
        return CommonResult.of(CODE.SUCCESS, DEFAULT_SUCCESS_MSG, data, DEFAULT_PORT);
    }

    /**
     * 失败返回
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> fail(String msg){
        return CommonResult.of(CODE.FAIL, msg, null, DEFAULT_PORT);
    }

    /**
     * 失败返回
     * @param code
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> fail(Integer code, String msg){
        return CommonResult.of(code, msg,null, DEFAULT_PORT);
    }

    /**
     * 自定义
     * @param code
     * @param msg
     * @param port
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> of(Integer code, String msg, T data, String port){
        CommonResult<T> commonResult = new CommonResult<>();
        commonResult.setCode(code);
        commonResult.setMsg(msg);
        commonResult.setData(data);
        commonResult.setPort(port);
        return commonResult;
    }

}
