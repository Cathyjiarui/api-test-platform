package com.example.apitestplatform.exception;

import lombok.Data;

/**
 * @ClassName CustomizeException
 * @Description 自定义异常类
 * @Author ZhangJia
 * @Date 2020/10/22
 * @Version 1.0
 **/
public class CustomizeException extends RuntimeException{

    private Integer code;

    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public CustomizeException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
