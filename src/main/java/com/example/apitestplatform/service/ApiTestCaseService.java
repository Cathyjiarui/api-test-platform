package com.example.apitestplatform.service;

import com.example.apitestplatform.model.entity.ApiTestCaseDO;
import com.example.apitestplatform.model.request.Pager;

import java.util.List;
import java.util.Map;

/**
 * @ClassName RepayTestStoryService
 * @Description 测试任务service
 * @Author ZhangJia
 * @Date 2022/03/24
 * @Version 1.0
 **/
public interface ApiTestCaseService {

    /**
     * 查询所有测试case信息
     * @param current
     * @param size
     * @param caseSerial
     * @return
     */
    Pager<ApiTestCaseDO> getApiList(int current, int size, String caseSerial);

    /**
     * 更新相关数据信息
     * @param apiInfo
     * @return
     */
    Boolean updateNotNullApi(Map<String, String> apiInfo);

    /**
     * 更具ID删除信息
     * @param id
     * @return
     */
    int deleteApiById(Integer id);
}
