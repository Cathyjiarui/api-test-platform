package com.example.apitestplatform.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.apitestplatform.model.entity.ApiTestCaseDO;

public interface ApiTestCaseMapper extends BaseMapper<ApiTestCaseDO> {

    Boolean updateNotNullApi(ApiTestCaseDO apiTestCaseDO);
}
