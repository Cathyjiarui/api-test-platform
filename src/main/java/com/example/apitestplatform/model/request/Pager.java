package com.example.apitestplatform.model.request;

import lombok.Data;

import java.util.List;

/**
 * @ClassName Pager
 * @Description 分页
 * @Author ZhangJia
 * @Date 2020/11/12
 * @Version 1.0
 **/
@Data
public class Pager<T> {

    /**
     * 当前页数
     */
    private int page;

    /**
     * 每页记录数
     */
    private int size;

    /**
     * 返回的记录集合
     */
    private List<T> rows;

    /**
     * 总条数
     */
    private long total;

    /**
     * 总页数
     */
    private long pages;
}
