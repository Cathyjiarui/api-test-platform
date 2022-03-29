package com.example.apitestplatform.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.apitestplatform.service.ApiTestCaseService;
import com.example.apitestplatform.service.NetworkRequestService;
import com.example.apitestplatform.utils.JsonData;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/pri/api_test_case")
public class ApiTestCaseController {

    @Autowired
    private ApiTestCaseService apiTestCaseService;

    @Autowired
    private NetworkRequestService networkRequestService;

    @GetMapping("api_list")
    public JsonData apiList(@Param("page") int page, @Param("size") int size, @Param("caseSerial") String caseSerial){
        return JsonData.buildSuccess(apiTestCaseService.getApiList(page,size,caseSerial));
    }

    @PutMapping("update_api")
    public JsonData updateApi(@RequestBody Map<String, String> apiInfo) {
        Boolean result = apiTestCaseService.updateNotNullApi(apiInfo);
        return result ? JsonData.buildSuccess() : JsonData.buildError("更新失败");
    }

    @DeleteMapping("delete_api")
    public JsonData deleteApiById(@Param("id") Integer id) {
        return apiTestCaseService.deleteApiById(id) == 1 ? JsonData.buildSuccess() : JsonData.buildError("删除失败");
    }

    @GetMapping("test_api")
    public JsonData testApi() {
        return JsonData.buildSuccess(networkRequestService.GetRequest());
    }
}
