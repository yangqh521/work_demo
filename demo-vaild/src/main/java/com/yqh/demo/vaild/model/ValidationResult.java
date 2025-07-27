package com.yqh.demo.vaild.model;

import lombok.Data;

import java.io.Serializable;


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
