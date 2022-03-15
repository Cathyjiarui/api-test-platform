package com.example.apitestplatform.utils;

import lombok.Data;

/**
 * @ClassName JsonData
 * @Description 响应信息格式化对象
 * @Author ZhangJia
 * @Date 2020/10/21
 * @Version 1.0
 **/
@Data
public class JsonData {

    /**
     * 状态码 0: 成功 1: 处理中 -1: 失败
     */
    private Integer code;

    /**
     * 业务数据
     */
    private Object data;

    /**
     * 信息描述
     */
    private String msg;

    public JsonData(){}

    public JsonData(Integer code, Object data, String msg){
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    /**
     * 成功，不返回数据
     * @return com.example.apitestplatform.utils.JsonData
     * @Exception
     **/
    public static JsonData buildSuccess(){
        return new JsonData(0, null, null);
    }

    /**
     * 成功，返回数据
     * @param data 返回的数据
     * @return com.example.apitestplatform.utils.JsonData
     * @Exception
     **/
    public static JsonData buildSuccess(Object data){
        return new JsonData(0, data, null);
    }

    /**
     * 失败，返回固定状态码
     * @param msg 错误信息
     * @return com.example.apitestplatform.utils.JsonData
     * @Exception
     **/
    public static JsonData buildError(String msg){
        return new JsonData(-1, null, msg);
    }

    /**
     * 失败，自定义状态码和信息
     * @param code 自定义错误码
     * @param msg 错误信息
     * @return
     */
    public static JsonData buildError(Integer code, String msg){
        return new JsonData(code, null, msg);
    }
}
