package com.example.apitestplatform.service;

import com.example.apitestplatform.model.entity.UserDO;
import com.example.apitestplatform.model.request.Pager;

import java.util.Map;

/**
 * @ClassName UserService
 * @Description 用户Service
 * @Author ZhangJia
 * @Date 2020/10/22
 * @Version 1.0
 **/
public interface UserService {

    /**
     * 新增用户
     * @param userInfo 用户信息
     * @return int
     * @Exception
     **/
    int saveUser(Map<String, String> userInfo);

    /**
     * 更新用户信息
     * @param userInfo 用户信息
     * @return java.lang.Boolean
     * @Exception
     **/
    Boolean updateNotNullUser(Map<String, String> userInfo);

    /**
     * 根据用户名和密码查询用户信息
     * @param name 用户名
     * @param pwd 用户密码
     * @return java.lang.String
     * @Exception
     **/
    String findByNameAndPwd(String name, String pwd);

    /**
     * 根据用户ID查询用户信息
     * @param userId 用户ID
     * @return com.example.apitestplatform.model.entity.User
     * @Exception
     **/
    UserDO findByUserId(Integer userId);

    /**
     * 获取用户列表
     * @param current 当前页
     * @param size 每一页的大小
     * @param userName 用户名
     * @return com.example.apitestplatform.model.request.Pager<com.example.apitestplatform.model.entity.User>
     * @Exception
     **/
    Pager<UserDO> getUserList(int current, int size, String userName);

    /**
     * 根据用户ID删除用户
     * @param id 用户ID
     * @return java.lang.Boolean
     * @Exception
     **/
    int deleteUserById(Integer id);
}
