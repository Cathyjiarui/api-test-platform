package com.example.apitestplatform.exception;

import com.example.apitestplatform.utils.JsonData;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName CustomExceptionHandler
 * @Description 异常处理类
 * @Author ZhangJia
 * @Date 2020/10/22
 * @Version 1.0
 **/
@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public JsonData handler(Exception e) {
        if (e instanceof CustomizeException) {
            CustomizeException customizeException = (CustomizeException) e;
            return JsonData.buildError(customizeException.getCode(), customizeException.getMsg());
        }else {
            return JsonData.buildError("未知错误！");
        }
    }
}
