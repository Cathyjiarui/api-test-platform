package com.example.apitestplatform.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.apitestplatform.model.entity.UserDO;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ZhangJia
 * @since 2021-01-22
 */
public interface UserMapper extends BaseMapper<UserDO> {

    /**
     * 根据ID更新用户信息
     * @param userDO 用户信息
     * @return java.lang.Boolean
     * @Exception
     **/
    Boolean updateNotNullUser(UserDO userDO);

}
