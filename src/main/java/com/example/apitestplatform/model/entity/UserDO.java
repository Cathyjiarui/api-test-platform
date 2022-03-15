package com.example.apitestplatform.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author ZhangJia
 * @since 2021-01-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user")
public class UserDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 创建时间
     */
    @TableField("create_time")
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 用户名/电话
     */
    @JsonProperty("name")
    @TableField("name")
    private String name;

    /**
     * 密码
     */
    @JsonIgnore
    @TableField("pwd")
    private String pwd;

    /**
     * 头像
     */
    @JsonProperty("head_img")
    @TableField("head_img")
    private String headImg;

    /**
     * 邮箱
     */
    @JsonProperty("mail_box")
    @TableField("mail_box")
    private String mailBox;

    /**
     * 年龄
     */
    @JsonProperty("age")
    @TableField("age")
    private Integer age;

    /**
     * 部门
     */
    @JsonProperty("department")
    @TableField("department")
    private String department;

    /**
     * 职位
     */
    @JsonProperty("position")
    @TableField("position")
    private String position;

}
