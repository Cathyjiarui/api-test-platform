package com.example.apitestplatform.model.request;

import lombok.Data;

/**
 * <p>
 * 登录 Request
 * </p>
 *
 * @author ZhangJia
 * @since 2021-01-22
 */
@Data
public class LoginRequest {

    /**
     * 用户名
     */
    private String name;

    /**
     * 密码
     */
    private String pwd;
}
