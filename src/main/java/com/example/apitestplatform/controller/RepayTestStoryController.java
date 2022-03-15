package com.example.apitestplatform.controller;

import com.example.apitestplatform.service.RepayTestStoryService;
import com.example.apitestplatform.utils.JsonData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @ClassName RepayTestStoryController
 * @Description 测试任务接口
 * @Author ZhangJia
 * @Date 2020/10/21
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api/v1/pri/story")
@Api(tags = "测试任务模块", value = "RepayTestStoryController")
public class RepayTestStoryController {

    @Autowired
    private RepayTestStoryService repayTestStoryService;

    /**
     * 查询未结束的故事以重要程度时间正序排列
     * @return com.example.apitestplatform.utils.JsonData
     * @Exception
     **/
    @GetMapping("not_over_case")
    @ApiOperation("测试任务列表")
    @ApiImplicitParams({@ApiImplicitParam(name = "page", value = "当前页"),
    @ApiImplicitParam(name = "size", value = "每页多少条")})
    public JsonData notOverCase(@Param("page") int page, @Param("size") int size){
        return JsonData.buildSuccess(repayTestStoryService.getNotOverCase(page, size));
    }

    /**
     * 根据ID更新重要程度
     * @param storyInfo 更新信息
     * @return com.example.apitestplatform.utils.JsonData
     * @Exception
     **/
    @PutMapping("update_is_important")
    @ApiOperation("更新重要程度")
    public JsonData updateIsImportant(@RequestBody Map<String, String> storyInfo){
        int rows = repayTestStoryService.updateIsImportantById(storyInfo);
        return rows == 1 ? JsonData.buildSuccess() : JsonData.buildError("更新失败！");
    }

    /**
     * 根据ID结束测试任务
     * @param id 测试任务ID
     * @return com.example.apitestplatform.utils.JsonData
     * @Exception
     **/
    @PutMapping("end_test_case/{id}")
    @ApiOperation("结束测试任务")
    public JsonData endTestCaseById(@PathVariable("id") Integer id){
        int rows = repayTestStoryService.endTestCaseById(id);
        return rows == 1 ? JsonData.buildSuccess() : JsonData.buildError("关闭失败！");
    }

    /**
     * 根据ID更新测试任务的领取状态
     * @param storyInfo 测试任务ID与用户名
     * @return com.example.apitestplatform.utils.JsonData
     * @Exception
     **/
    @PutMapping("receive_test_case")
    @ApiOperation("更新测试任务的领取状态")
    public JsonData receiveTestCase(@RequestBody Map<String, String> storyInfo) {
        int rows = repayTestStoryService.receiveTestCase(storyInfo);
        return rows == 1 ? JsonData.buildSuccess() : JsonData.buildError("领取失败！");
    }

    /**
     * 根据测试任务编号查询测试任务
     * @param associationStoryPoint 测试任务编号
     * @return com.example.apitestplatform.utils.JsonData
     * @Exception
     **/
    @GetMapping("find_testCase_by_association_story_point")
    @ApiOperation("根据测试任务编号查询测试任务")
    public JsonData findTestCaseByAssociationStoryPoint(@RequestParam(value = "association_story_point") String associationStoryPoint) {
        return JsonData.buildSuccess(repayTestStoryService.findTestCaseByAssociationStoryPoint(associationStoryPoint));
    }

    /**
     * 根据ID查询测试任务
     * @param id 测试任务ID
     * @return com.example.apitestplatform.utils.JsonData
     * @Exception
     **/
    @GetMapping("find_test_case_by_id/{id}")
    @ApiOperation("根据ID查询测试任务")
    public JsonData findTestCaseById(@PathVariable("id") Integer id) {
        return JsonData.buildSuccess(repayTestStoryService.findTestCaseById(id));
    }

    /**
     * 根据ID更新测试任务
     * @param repayTestStoryInfoDO 测试任务内容
     * @return com.example.apitestplatform.utils.JsonData
     * @Exception
     **/
    @PutMapping("update_case_by_id")
    @ApiOperation("根据ID更新测试任务")
    public JsonData updateCaseById(@RequestBody Map<String, String> repayTestStoryInfoDO){
        int rows = repayTestStoryService.updateCaseById(repayTestStoryInfoDO);
        return rows == 1 ? JsonData.buildSuccess() : JsonData.buildError("更新失败！");
    }

    /**
     * 添加新的测试任务
     * @param repayTestStoryInfo 测试任务
     * @return com.example.apitestplatform.utils.JsonData
     * @Exception
     **/
    @PostMapping("insert_test_case")
    @ApiOperation("添加新的测试任务")
    public JsonData insertTestCase(@RequestBody Map<String, String> repayTestStoryInfo) {
        int rows = repayTestStoryService.insertTestCase(repayTestStoryInfo);
        return rows == 1 ? JsonData.buildSuccess() : JsonData.buildError("添加失败！");
    }
}
