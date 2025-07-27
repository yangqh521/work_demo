package com.yqh.demo.vaild.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: yangqinghui@cfhy.com
 * @Description:
 * @Date: Created in 09:52 2025/7/25
 * @Modified By:
 */
@Data
public class ValidationResult implements Serializable {
    private boolean success = true;
    private Integer errorCode;
    private String errorMsg;

    public void setError(Integer errorCode, String errorMsg) {
        this.setSuccess(false);
        this.setErrorCode(errorCode);
        this.setErrorMsg(errorMsg);
    }

}
