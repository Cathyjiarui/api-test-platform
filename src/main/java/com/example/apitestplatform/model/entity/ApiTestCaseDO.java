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
@TableName("api_test_case")
public class ApiTestCaseDO implements Serializable {

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
     * 是否执行：1.执行 0.不执行
     */
    @JsonProperty("is_implement")
    @TableField("is_implement")
    private Integer isImplement;

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
     * 用例名称
     */
    @JsonProperty("case_name")
    @TableField("case_name")
    private String caseName;

    /**
     * 请求类型（1.get 2.post 3.put 4.delete）
     */
    @JsonProperty("request_type")
    @TableField("request_type")
    private Integer requestType;

    /**
     * Api地址
     */
    @JsonProperty("api_address")
    @TableField("api_address")
    private String apiAddress;

    /**
     * 请求参数
     */
    @JsonProperty("request_parameter")
    @TableField("request_parameter")
    private String requestParameter;

    /**
     * 预期响应信息
     */
    @JsonProperty("response_text")
    @TableField("response_text")
    private String responseText;
}
