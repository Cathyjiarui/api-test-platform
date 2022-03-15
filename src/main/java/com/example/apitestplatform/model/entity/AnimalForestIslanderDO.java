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

/**
 * <p>
 * 动森岛民表
 * </p>
 *
 * @author ZhangJia
 * @since 2021-01-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("animal_forest_islander")
public class AnimalForestIslanderDO implements Serializable {

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
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date updateTime;

    /**
     * 动物名称
     */
    @JsonProperty("animal_name")
    @TableField("animal_name")
    private String animalName;

    /**
     * amiibo序号
     */
    @JsonProperty("amiibo_id")
    @TableField("amiibo_id")
    private String amiiboId;

    /**
     * 性别：1.男 2.女
     */
    @JsonProperty("sex")
    @TableField("sex")
    private Integer sex;

    /**
     * 种族
     */
    @JsonProperty("race")
    @TableField("race")
    private String race;

    /**
     * 性格
     */
    @JsonProperty("disposition")
    @TableField("disposition")
    private String disposition;

    /**
     * 生日
     */
    @JsonProperty("birthday")
    @TableField("birthday")
    private String birthday;

    /**
     * 推荐礼物1
     */
    @JsonProperty("gift_one")
    @TableField("gift_one")
    private String giftOne;

    /**
     * 推荐礼物2
     */
    @JsonProperty("gift_two")
    @TableField("gift_two")
    private String giftTwo;

    /**
     * 推荐礼物3
     */
    @JsonProperty("gift_three")
    @TableField("gift_three")
    private String giftThree;

    /**
     * 推荐礼物4
     */
    @JsonProperty("gift_four")
    @TableField("gift_four")
    private String giftFour;

    /**
     * 喜爱歌曲
     */
    @JsonProperty("favorite_song")
    @TableField("favorite_song")
    private String favoriteSong;

    /**
     * 喜爱颜色
     */
    @JsonProperty("favorite_colour")
    @TableField("favorite_colour")
    private String favoriteColour;

    /**
     * 图片地址
     */
    @JsonProperty("img_url")
    @TableField("img_url")
    private String imgUrl;

}
