package com.example.apitestplatform.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("api_test_result")
public class ApiTestResultDO implements Serializable {

    public static final long serialVersionUID = 1L;

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
     * 模块名称
     */
    @JsonProperty("module_name")
    @TableField("module_name")
    private String moduleName;

    /**
     * 用例编号
     */
    @JsonProperty("case_serial")
    @TableField("case_serial")
    private String caseSerial;

    /**
     * 测试时间
     */
    @JsonProperty("test_time")
    @TableField("test_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT-8")
    private Date testTime;

    /**
     * 实际结果
     */
    @JsonProperty("actual_results")
    @TableField("actual_results")
    private String actualResults;

    /**
     * 是否通过：1.通过 0.不通过
     */
    @JsonProperty("is_pass")
    @TableField("is_pass")
    private Integer isPass;
}
