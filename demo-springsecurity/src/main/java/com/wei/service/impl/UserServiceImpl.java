package com.wei.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.AES;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wei.dao.mapper.UserMapper;
import com.wei.entity.po.UserInfo;
import com.wei.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 82043
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserInfo> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserInfo getUserByName(String username) {
        LambdaQueryWrapper<UserInfo> wrapper1 = Wrappers.<UserInfo>lambdaQuery().eq(UserInfo::getUsername, username);
        return getOne(wrapper1);
    }

    public static void main(String[] args) {
        // 生成 16 位随机 AES 密钥
        String randomKey = AES.generateRandomKey();
        System.out.println(randomKey);

        // 随机密钥加密
        String result = AES.encrypt("sfawffsdf", randomKey);
        System.out.println(result);
    }

}
