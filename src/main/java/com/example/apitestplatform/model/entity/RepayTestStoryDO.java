package com.example.apitestplatform.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * <p>
 * 测试任务表
 * </p>
 *
 * @author ZhangJia
 * @since 2021-01-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("repay_test_story")
@ToString(exclude = {"createTime"})
public class RepayTestStoryDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 创建时间
     */
    @JsonProperty("create_time")
    @TableField("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createTime;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    @TableField("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    /**
     * 测试员名称
     */
    @JsonProperty("user_name")
    @TableField("user_name")
    private String userName;

    /**
     * Git地址
     */
    @JsonProperty("git_address")
    @TableField("git_address")
    private String gitAddress;

    /**
     * 关联故事点
     */
    @JsonProperty("association_story_point")
    @TableField("association_story_point")
    private String associationStoryPoint;

    /**
     * 是否领取： 1.已领取 0.未领取
     */
    @JsonProperty("receive")
    @TableField("receive")
    private Integer receive;

    /**
     * 是否结束： 1。已结束 0. 未结束
     */
    @JsonProperty("test_over")
    @TableField("test_over")
    private Integer testOver;

    /**
     * 故事内容
     */
    @JsonProperty("story_content")
    @TableField("story_content")
    private String storyContent;

    /**
     * 是否重要: 1.重要 0.非重要
     */
    @JsonProperty("is_important")
    @TableField("is_important")
    private Integer isImportant;

}
