package com.example.apitestplatform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.apitestplatform.config.ConstString;
import com.example.apitestplatform.mapper.ApiTestCaseMapper;
import com.example.apitestplatform.model.entity.ApiTestCaseDO;
import com.example.apitestplatform.model.request.Pager;
import com.example.apitestplatform.service.ApiTestCaseService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ApiTestCaseServiceImpl implements ApiTestCaseService {

    @Autowired
    private ApiTestCaseMapper apiTestCaseMapper;


    @Override
    public Pager<ApiTestCaseDO> getApiList(int current, int size, String caseSerial) {
        //声明返回信息
        Pager<ApiTestCaseDO> returnPager = new Pager<>();
        //创建筛选条件
        QueryWrapper<ApiTestCaseDO> queryWrapper = new QueryWrapper<>();
        if (caseSerial != null && !"".equals(caseSerial)) {
            queryWrapper.like("caseSerial", caseSerial);
        }
        Page<ApiTestCaseDO> page = new Page<>(current, size);
        IPage<ApiTestCaseDO> iPage = apiTestCaseMapper.selectPage(page, queryWrapper);
        returnPager.setPage(current);
        returnPager.setSize(size);
        returnPager.setTotal(iPage.getTotal());
        returnPager.setPages(iPage.getPages());
        returnPager.setRows(iPage.getRecords());
        return returnPager;
    }

    @Override
    public Boolean updateNotNullApi(Map<String, String> apiInfo) {
        ApiTestCaseDO apiTestCaseDO = parseToApi(apiInfo);
        return apiTestCaseMapper.updateNotNullApi(apiTestCaseDO);
    }

    @Override
    public int deleteApiById(Integer id) {
        return apiTestCaseMapper.deleteById(id);
    }

    private ApiTestCaseDO parseToApi(Map<String, String> apiInfo) {
        ApiTestCaseDO apiTestCaseDO = new ApiTestCaseDO();
        if (!apiInfo.containsKey(ConstString.API_ID)) {
            apiTestCaseDO.setCreateTime(new Date());
        }
        apiInfo.forEach((key, value) -> {
            switch (key) {
                case ConstString.API_ID:
                    apiTestCaseDO.setId(Long.parseLong(value));
                    break;
                case ConstString.IS_IMPLEMENT:
                    apiTestCaseDO.setIsImplement(Integer.parseInt(value));
                    break;
                case ConstString.MODULE_NAME:
                    apiTestCaseDO.setModuleName(value);
                    break;
                case ConstString.CASE_SERIAL:
                    apiTestCaseDO.setCaseSerial(value);
                    break;
                case ConstString.CASE_NAME:
                    apiTestCaseDO.setCaseName(value);
                    break;
                case ConstString.REQUEST_TYPE:
                    apiTestCaseDO.setRequestType(Integer.parseInt(value));
                    break;
                case ConstString.API_ADDRESS:
                    apiTestCaseDO.setApiAddress(value);
                    break;
                case ConstString.REQUEST_PARAMETER:
                    apiTestCaseDO.setRequestParameter(value);
                    break;
                case ConstString.RESPONSE_TEXT:
                    apiTestCaseDO.setResponseText(value);
                    break;
                default:
                    break;
            }
        });
        return apiTestCaseDO;
    }
}
