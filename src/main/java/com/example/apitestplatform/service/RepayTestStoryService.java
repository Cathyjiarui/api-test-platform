package com.example.apitestplatform.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.apitestplatform.model.entity.RepayTestStoryDO;
import com.example.apitestplatform.model.request.Pager;

import java.util.Map;

/**
 * @ClassName RepayTestStoryService
 * @Description 测试任务service
 * @Author ZhangJia
 * @Date 2020/10/21
 * @Version 1.0
 **/
public interface RepayTestStoryService {

    /**
     * 查询所有未结束测试任务
     * @param page 当前页
     * @param size 每页大小
     * @return java.util.List<com.example.apitestplatform.model.entity.RepayTestStory>
     * @Exception
     **/
    Pager<RepayTestStoryDO> getNotOverCase(int page, int size);

    /**
     * 根据ID更新重要程度
     * @param storyInfo 更新的数据
     * @return int
     * @Exception
     **/
    int updateIsImportantById(Map<String, String> storyInfo);

    /**
     * 根据ID结束测试任务
     * @param id 测试任务ID
     * @return int
     * @Exception
     **/
    int endTestCaseById(Integer id);

    /**
     * 根据ID更新测试任务的领取状态
     * @param storyInfo 测试任务ID与用户名
     * @return int
     * @Exception
     **/
    int receiveTestCase(Map<String, String> storyInfo);

    /**
     * 根据测试任务编号查询测试任务
     * @param associationStoryPoint 测试任务编号
     * @return com.example.apitestplatform.model.entity.RepayTestStory
     * @Exception
     **/
    RepayTestStoryDO findTestCaseByAssociationStoryPoint(String associationStoryPoint);

    /**
     * 根据ID查询测试任务
     * @param id 测试任务ID
     * @return com.example.apitestplatform.model.entity.RepayTestStory
     * @Exception
     **/
    RepayTestStoryDO findTestCaseById(Integer id);

    /**
     * 根据ID更新测试任务
     * @param repayTestStoryInfoDO 测试任务内容
     * @return int
     * @Exception
     **/
    int updateCaseById(Map<String, String> repayTestStoryInfoDO);

    /**
     * 插入测试任务
     * @param repayTestStoryInfo 测试任务内容
     * @return int
     * @Exception
     **/
    int insertTestCase(Map<String, String> repayTestStoryInfo);
}
