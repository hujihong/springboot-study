package com.boot.study.exception;

/**
 * Created by hujh on 2018/3/24.
 */
public class TResult {

    private String errorMessage;
    private Integer status;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
