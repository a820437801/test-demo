package com.wei.demo_springsecurity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wei.demo_springsecurity.entity.po.UserInfo;
import org.springframework.stereotype.Repository;

/**
 * @author 82043
 */
@Repository
public interface UserMapper extends BaseMapper<UserInfo> {
}
