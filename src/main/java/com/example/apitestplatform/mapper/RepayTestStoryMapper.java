package com.example.apitestplatform.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.apitestplatform.model.entity.RepayTestStoryDO;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 测试任务表 Mapper 接口
 * </p>
 *
 * @author ZhangJia
 * @since 2021-01-22
 */
public interface RepayTestStoryMapper extends BaseMapper<RepayTestStoryDO> {

    /**
     * 根据ID更新测试任务
     * @param repayTestStoryDO 测试任务内容
     * @return 更新行数
     */
    int updateCaseById(@Param("repayTestStoryDO") RepayTestStoryDO repayTestStoryDO);
}
