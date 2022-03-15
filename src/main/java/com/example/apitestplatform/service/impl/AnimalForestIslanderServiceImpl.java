package com.example.apitestplatform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.apitestplatform.mapper.AnimalForestIslanderMapper;
import com.example.apitestplatform.model.entity.AnimalForestIslanderDO;
import com.example.apitestplatform.model.request.Pager;
import com.example.apitestplatform.service.AnimalForestIslanderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @ClassName AnimalForestIslanderServiceImpl
 * @Description 小动物实现层
 * @Author ZhangJia
 * @Date 2021/1/26
 * @Version 1.0
 **/
@Service
public class AnimalForestIslanderServiceImpl implements AnimalForestIslanderService {

    @Autowired
    private AnimalForestIslanderMapper animalForestIslanderMapper;

    /**
     * 分页查询小动物信息
     * @param current 当前页
     * @param size 每页条数
     * @param disposition 性格
     * @return com.example.apitestplatform.model.request.Pager<com.example.apitestplatform.model.entity.AnimalForestIslanderDO>
     * @Exception
     **/
    @Override
    public Pager<AnimalForestIslanderDO> listAll(int current, int size, String disposition) {
        //声明返回信息
        Pager<AnimalForestIslanderDO> returnData = new Pager<>();
        //判断有无筛选条件
        QueryWrapper<AnimalForestIslanderDO> queryWrapper = new QueryWrapper<>();
        if (Objects.nonNull(disposition)) {
            queryWrapper.like("disposition", disposition);
        }
        //分页
        Page<AnimalForestIslanderDO> page = new Page<>(current, size);
        IPage<AnimalForestIslanderDO> iPage = animalForestIslanderMapper.selectPage(page, queryWrapper);
        returnData.setPage(current);
        returnData.setSize(size);
        returnData.setTotal(iPage.getTotal());
        returnData.setPages(iPage.getPages());
        returnData.setRows(iPage.getRecords());
        return returnData;
    }

    @Override
    public AnimalForestIslanderDO getAnimalById(int id) {
        return animalForestIslanderMapper.selectById(id);
    }

    @Override
    public List<AnimalForestIslanderDO> getAnimalByDisposition(String disposition) {
        return animalForestIslanderMapper.selectList(new QueryWrapper<AnimalForestIslanderDO>().eq("disposition",disposition));
    }
}
