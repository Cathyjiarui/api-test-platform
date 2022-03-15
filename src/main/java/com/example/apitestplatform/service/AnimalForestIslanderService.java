package com.example.apitestplatform.service;

import com.example.apitestplatform.model.entity.AnimalForestIslanderDO;
import com.example.apitestplatform.model.request.Pager;

import java.util.List;

/**
 * @ClassName AnimalForestIslanderService
 * @Description 小动物service
 * @Author ZhangJia
 * @Date 2021/1/26
 * @Version 1.0
 **/
public interface AnimalForestIslanderService {

    /**
     * 分页查询小动物信息
     *
     * @param current 当前页
     * @param size    每页多少条
     * @return com.example.apitestplatform.model.request.Pager<com.example.apitestplatform.model.entity.AnimalForestIslanderDO>
     * @Exception
     **/
    Pager<AnimalForestIslanderDO> listAll(int current, int size, String disposition);

    /**
     * 根据ID获取信息
     * @param id 小动物ID
     * @return com.example.apitestplatform.model.entity.AnimalForestIslanderDO
     * @Exception
     **/
    AnimalForestIslanderDO getAnimalById(int id);

    /**
     * 根据性格查询岛民
     * @param disposition 性格
     * @return java.util.List<com.example.apitestplatform.model.entity.AnimalForestIslanderDO>
     * @Exception
     **/
    List<AnimalForestIslanderDO> getAnimalByDisposition(String disposition);
}
