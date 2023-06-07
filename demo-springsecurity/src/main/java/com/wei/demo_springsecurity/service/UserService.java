package com.wei.demo_springsecurity.service;

import com.wei.demo_springsecurity.entity.po.UserInfo;

/**
 * @author 82043
 */
public interface UserService {

    UserInfo getUserByName(String username);

}
