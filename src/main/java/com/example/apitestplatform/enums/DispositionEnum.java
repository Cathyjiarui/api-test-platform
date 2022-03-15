package com.example.apitestplatform.enums;

import com.baomidou.mybatisplus.annotation.IEnum;

/**
 * @ClassName DispositionEnum
 * @Description 性格枚举
 * @Author ZhangJia
 * @Date 2021/2/4
 * @Version 1.0
 **/
public enum DispositionEnum {

    /**
     * 枚举
     */
    ORDINARY("ordinary", "普通"),
    LEISURELY("leisurely", "悠闲"),
    MOVEMENT("movement", "运动"),
    IRRITABLE("irritable", "暴躁"),
    VITALITY("vitality", "元气"),
    MATURE("mature", "成熟"),
    NARCISSISM("narcissism", "自恋"),
    BIGSISTER("bigSister", "大姐姐");

    /**
     * 初始化
     *
     * @param value       编码
     * @param disposition 说明
     * @return
     * @Exception
     **/
    DispositionEnum(String value, String disposition) {
        this.value = value;
        this.disposition = disposition;
    }

    /**
     * 编码
     */
    private String value;

    /**
     * 说明
     */
    private String disposition;

    public void setValue(String value) {
        this.value = value;
    }

    public void setDisposition(String disposition) {
        this.disposition = disposition;
    }

    public String getValue() {
        return this.value;
    }

    public String getDisposition() {
        return this.disposition;
    }

    public static String getDisposition(String value) {
        for (DispositionEnum dispositionEnum : DispositionEnum.values()) {
            if (dispositionEnum.getValue().equals(value)) {
                return dispositionEnum.disposition;
            }
        }
        return null;
    }

}