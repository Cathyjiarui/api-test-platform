package com.example.apitestplatform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.apitestplatform.config.ConstString;
import com.example.apitestplatform.mapper.UserMapper;
import com.example.apitestplatform.model.entity.UserDO;
import com.example.apitestplatform.model.request.Pager;
import com.example.apitestplatform.service.UserService;
import com.example.apitestplatform.utils.CommonUtils;
import com.example.apitestplatform.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

/**
 * @ClassName UserServiceImpl
 * @Description 用户实现层
 * @Author ZhangJia
 * @Date 2021/1/25
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int saveUser(Map<String, String> userInfo) {

        UserDO userDO = parseToUser(userInfo);
        if (Objects.nonNull(userDO)) {
            return userMapper.insert(userDO);
        } else {
            return -1;
        }
    }

    @Override
    public Boolean updateNotNullUser(Map<String, String> userInfo) {
        UserDO userDO = parseToUser(userInfo);
        if (Objects.nonNull(userDO)) {
            return userMapper.updateNotNullUser(userDO);
        } else {
            return false;
        }
    }

    /**
     * 根据用户名和密码查询用户信息
     *
     * @param name 用户名
     * @param pwd  密码
     * @return java.lang.String
     * @Exception
     **/
    @Override
    public String findByNameAndPwd(String name, String pwd) {
        UserDO userDO = userMapper.selectOne(new QueryWrapper<UserDO>().eq("name", name).eq("pwd", CommonUtils.MD5(pwd)));
        if (Objects.isNull(userDO)) {
            return null;
        } else {
            String token = JwtUtils.geneJsonWebToken(userDO);
            return token;
        }
    }

    @Override
    public UserDO findByUserId(Integer userId) {
        return userMapper.selectById(userId);
    }

    @Override
    public Pager<UserDO> getUserList(int current, int size, String userName) {
        //声明返回信息
        Pager<UserDO> returnPager = new Pager<>();
        //创建筛选条件
        QueryWrapper<UserDO> queryWrapper = new QueryWrapper<>();
        if (userName != null && !"".equals(userName)) {
            queryWrapper.like("name", userName);
        }
        Page<UserDO> page = new Page<>(current, size);
        IPage<UserDO> iPage = userMapper.selectPage(page, queryWrapper);
        returnPager.setPage(current);
        returnPager.setSize(size);
        returnPager.setTotal(iPage.getTotal());
        returnPager.setPages(iPage.getPages());
        returnPager.setRows(iPage.getRecords());
        return returnPager;
    }

    @Override
    public int deleteUserById(Integer id) {
        return userMapper.deleteById(id);
    }

    private UserDO parseToUser(Map<String, String> userInfo) {
        UserDO userDO = new UserDO();
        if (!userInfo.containsKey(ConstString.USER_ID)) {
            userDO.setCreateTime(new Date());
            String pwd = userInfo.get("pwd");
            userDO.setPwd(CommonUtils.MD5(pwd));
            userDO.setHeadImg(getRandomImg());
        }
        userInfo.forEach((key, value) -> {
            switch (key) {
                case ConstString.USER_ID:
                    userDO.setId(Integer.parseInt(value));
                    break;
                case ConstString.NAME:
                    userDO.setName(value);
                    break;
                case ConstString.USER_MAIL_BOX:
                    userDO.setMailBox(value);
                    break;
                case ConstString.USER_AGE:
                    userDO.setAge(Integer.parseInt(value));
                    break;
                case ConstString.USER_DEPARTMENT:
                    userDO.setDepartment(value);
                    break;
                case ConstString.USER_POSITION:
                    userDO.setPosition(value);
                    break;
                default:
                    break;
            }
        });
        return userDO;
    }

    /**
     * 头像信息
     */
    private static final String[] headImg = {
            "http://img.cathyjiarui.com/1.jpeg",
            "http://img.cathyjiarui.com/2.jpg",
            "http://img.cathyjiarui.com/3.jpeg",
            "http://img.cathyjiarui.com/4.jpg",
            "http://img.cathyjiarui.com/5.jpeg"
    };

    /**
     * 获取随机头像
     *
     * @return java.lang.String
     * @Exception
     **/
    private String getRandomImg() {
        int size = headImg.length;
        Random random = new Random();
        int index = random.nextInt(size);
        return headImg[index];
    }
}
