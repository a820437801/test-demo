package com.wei.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wei.entity.po.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author 82043
 */
@Repository
public interface UserMapper extends BaseMapper<UserInfo> {

    /**
     * 通过用户名查询用户
     * @param username 用户名
     * @return 用户信息
     */
    UserInfo getUserByName(@Param("username") String username);

}
