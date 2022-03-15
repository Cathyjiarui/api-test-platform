package com.example.apitestplatform.controller;

import com.example.apitestplatform.model.entity.UserDO;
import com.example.apitestplatform.model.request.LoginRequest;
import com.example.apitestplatform.service.UserService;
import com.example.apitestplatform.utils.JsonData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Objects;

/**
 * @ClassName UserController
 * @Description 用户服务
 * @Author ZhangJia
 * @Date 2020/10/22
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api/v1/pri/user")
@Api(tags = "用户模块", value = "userController")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 添加用户接口
     *
     * @param userInfo 用户信息
     * @return com.example.apitestplatform.utils.JsonData
     * @Exception
     **/
    @PostMapping("save_user")
    @ApiOperation("添加用户接口")
    public JsonData register(@RequestBody Map<String, String> userInfo) {
        int rows = userService.saveUser(userInfo);
        return rows == 1 ? JsonData.buildSuccess() : JsonData.buildError("添加失败！");
    }

    /**
     * 更新用户数据
     * @param userInfo 用户数据
     * @return com.example.apitestplatform.utils.JsonData
     * @Exception
     **/
    @PutMapping("update_user")
    @ApiOperation("更新用户数据")
    public JsonData updateNotNullUser(@RequestBody Map<String, String> userInfo) {
        boolean result = userService.updateNotNullUser(userInfo);
        return result ? JsonData.buildSuccess() : JsonData.buildError("更新失败");
    }

    /**
     * 登录接口
     *
     * @param loginRequest 登录信息
     * @return com.example.apitestplatform.utils.JsonData
     * @Exception
     **/
    @PostMapping("login")
    @ApiOperation("登录接口")
    public JsonData login(@RequestBody LoginRequest loginRequest) {
        String token = userService.findByNameAndPwd(loginRequest.getName(), loginRequest.getPwd());
        return Objects.isNull(token) ? JsonData.buildError("登录失败") : JsonData.buildSuccess(token);
    }

    /**
     * 根据用户token查询用户信息
     * @param request 请求信息
     * @return com.example.apitestplatform.utils.JsonData
     * @Exception
     **/
    @GetMapping("find_by_token")
    @ApiOperation("根据用户token查询用户信息")
    public JsonData findUserByToken(HttpServletRequest request) {
        Integer userId = (Integer) request.getAttribute("user_id");
        if (Objects.isNull(userId)) {
            return JsonData.buildError("查询失败！");
        }
        UserDO user = userService.findByUserId(userId);
        return JsonData.buildSuccess(user);
    }

    /**
     * 分页查询用户列表
     * @param page 当前页
     * @param size 每页多少条数据
     * @return com.example.apitestplatform.utils.JsonData
     * @Exception
     **/
    @GetMapping("user_list")
    @ApiOperation("分页查询用户列表")
    public JsonData userList(@Param("page") int page, @Param("size") int size, @Param("userName") String userName){
        return JsonData.buildSuccess(userService.getUserList(page, size,userName));
    }

    /**
     * 根据用户ID删除用户
     * @param id 用户ID
     * @return com.example.apitestplatform.utils.JsonData
     * @Exception
     **/
    @DeleteMapping("delete_user")
    @ApiOperation("根据用户ID删除用户")
    @ApiImplicitParam(name = "用户ID", value = "id")
    public JsonData deleteUserById(@Param("id") Integer id) {
        int result = userService.deleteUserById(id);
        return result == 1 ? JsonData.buildSuccess() : JsonData.buildError("删除失败");
    }

}
