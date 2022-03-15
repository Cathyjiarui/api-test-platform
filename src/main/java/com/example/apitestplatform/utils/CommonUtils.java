package com.example.apitestplatform.utils;

import java.security.MessageDigest;

/**
 * @ClassName CommonUtils
 * @Description 日常工具类
 * @Author ZhangJia
 * @Date 2020/10/22
 * @Version 1.0
 **/
public class CommonUtils {

    /**
     * MD5加密工具
     * @param data 数据
     * @return java.lang.String
     * @Exception
     **/
    public static String MD5(String data) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(data.getBytes("UTF-8"));
            StringBuilder stringBuilder = new StringBuilder();
            for (byte item : array) {
                stringBuilder.append(Integer.toHexString((item & 0xff) | 0x100).substring(1, 3));
            }
            return stringBuilder.toString().toUpperCase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
