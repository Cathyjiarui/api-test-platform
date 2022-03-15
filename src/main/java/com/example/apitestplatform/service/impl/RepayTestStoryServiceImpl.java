package com.example.apitestplatform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.apitestplatform.config.ConstString;
import com.example.apitestplatform.mapper.RepayTestStoryMapper;
import com.example.apitestplatform.model.entity.RepayTestStoryDO;
import com.example.apitestplatform.model.request.Pager;
import com.example.apitestplatform.service.RepayTestStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * @ClassName RepayTestStoryServiceImpl
 * @Description 测试任务实现类
 * @Author ZhangJia
 * @Date 2021/1/25
 * @Version 1.0
 **/
@Service
public class RepayTestStoryServiceImpl implements RepayTestStoryService {

    @Autowired
    private RepayTestStoryMapper repayTestStoryMapper;

    /**
     * 查询所有未结束测试任务
     *
     * @param current 当前页
     * @param size    每页大小
     * @return com.example.apitestplatform.model.request.Pager<com.example.apitestplatform.model.entity.RepayTestStoryDO>
     * @Exception
     **/
    @Override
    public Pager<RepayTestStoryDO> getNotOverCase(int current, int size) {
        //声明返回信息
        Pager<RepayTestStoryDO> returnPager = new Pager<>();
        //创建筛选条件
        QueryWrapper<RepayTestStoryDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("test_over", 0).orderByDesc("is_important");
        Page<RepayTestStoryDO> page = new Page<>(current, size);
        IPage<RepayTestStoryDO> iPage = repayTestStoryMapper.selectPage(page, queryWrapper);
        returnPager.setPage(current);
        returnPager.setSize(size);
        returnPager.setTotal(iPage.getTotal());
        returnPager.setPages(iPage.getPages());
        returnPager.setRows(iPage.getRecords());
        return returnPager;
    }

    /**
     * 根据ID更新重要程度
     *
     * @param storyInfo 信息
     * @return int
     * @Exception
     **/
    @Override
    public int updateIsImportantById(Map<String, String> storyInfo) {
        if (storyInfo.containsKey(ConstString.ID) && storyInfo.containsKey(ConstString.IS_IMPORTANT)) {
            UpdateWrapper<RepayTestStoryDO> updateWrapper = new UpdateWrapper<>();
            updateWrapper
                    .eq("id", storyInfo.get("id"))
                    .set("is_important", storyInfo.get("is_important"));
            return repayTestStoryMapper.update(new RepayTestStoryDO(), updateWrapper);
        } else {
            return 0;
        }
    }

    /**
     * 根据ID结束测试任务
     *
     * @param id 任务ID
     * @return int
     * @Exception
     **/
    @Override
    public int endTestCaseById(Integer id) {
        UpdateWrapper<RepayTestStoryDO> updateWrapper = new UpdateWrapper<>();
        updateWrapper
                .eq("id", id)
                .set("test_over", 1);
        return repayTestStoryMapper.update(new RepayTestStoryDO(), updateWrapper);
    }

    /**
     * 根据ID更新测试任务的领取状态
     *
     * @param storyInfo 信息
     * @return int
     * @Exception
     **/
    @Override
    public int receiveTestCase(Map<String, String> storyInfo) {
        if (storyInfo.containsKey(ConstString.ID) && storyInfo.containsKey(ConstString.USER_NAME) && storyInfo.containsKey(ConstString.RECEIVE)) {
            UpdateWrapper<RepayTestStoryDO> updateWrapper = new UpdateWrapper<>();
            updateWrapper
                    .eq("id", storyInfo.get("id"))
                    .set("user_name", storyInfo.get("user_name"))
                    .set("receive", storyInfo.get("receive"));
            return repayTestStoryMapper.update(new RepayTestStoryDO(), updateWrapper);
        } else {
            return 0;
        }
    }

    /**
     * 根据测试任务编号查询测试任务
     * @param associationStoryPoint 测试任务编号
     * @return com.example.apitestplatform.model.entity.RepayTestStoryDO
     * @Exception
     **/
    @Override
    public RepayTestStoryDO findTestCaseByAssociationStoryPoint(String associationStoryPoint) {
        QueryWrapper<RepayTestStoryDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("association_story_point", associationStoryPoint);
        return repayTestStoryMapper.selectOne(queryWrapper);
    }

    /**
     * 根据ID查询测试任务
     * @param id 测试任务ID
     * @return com.example.apitestplatform.model.entity.RepayTestStoryDO
     * @Exception
     **/
    @Override
    public RepayTestStoryDO findTestCaseById(Integer id) {
        return repayTestStoryMapper.selectById(id);
    }

    /**
     * 根据ID更新测试任务
     * @param repayTestStoryInfoDO 测试任务信息
     * @return int
     * @Exception
     **/
    @Override
    public int updateCaseById(Map<String, String> repayTestStoryInfoDO) {
        RepayTestStoryDO repayTestStoryDO = parseToRepayTestStory(repayTestStoryInfoDO);
        return repayTestStoryMapper.updateCaseById(repayTestStoryDO);
    }

    /**
     * 插入测试任务
     * @param repayTestStoryInfo 测试任务内容
     * @return int
     * @Exception
     **/
    @Override
    public int insertTestCase(Map<String, String> repayTestStoryInfo) {
        RepayTestStoryDO repayTestStoryDO = parseToRepayTestStory(repayTestStoryInfo);
        repayTestStoryDO.setCreateTime(new Date());
        return repayTestStoryMapper.insert(repayTestStoryDO);
    }

    private RepayTestStoryDO parseToRepayTestStory(Map<String, String> repayTestStoryInfoDO){
        RepayTestStoryDO repayTestStoryDO = new RepayTestStoryDO();
        repayTestStoryInfoDO.forEach((key,val) -> {
            switch (key){
                case ConstString.ID:
                    repayTestStoryDO.setId(Long.parseLong(val));
                    break;
                case ConstString.USER_NAME:
                    repayTestStoryDO.setUserName(val);
                    break;
                case ConstString.GIT_ADDRESS:
                    repayTestStoryDO.setGitAddress(val);
                    break;
                case ConstString.ASSOCIATION_STORY_POINT:
                    repayTestStoryDO.setAssociationStoryPoint(val);
                    break;
                case ConstString.RECEIVE:
                    repayTestStoryDO.setReceive(Integer.parseInt(val));
                    break;
                case ConstString.TEST_OVER:
                    repayTestStoryDO.setTestOver(Integer.parseInt(val));
                    break;
                case ConstString.STORY_CONTENT:
                    repayTestStoryDO.setStoryContent(val);
                    break;
                case ConstString.IS_IMPORTANT:
                    repayTestStoryDO.setIsImportant(Integer.parseInt(val));
                    break;
                default:
                    break;
            }
        });
        return repayTestStoryDO;
    }
}
