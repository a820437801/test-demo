package com.wei.demo_springsecurity.cotroller;

import com.wei.demo_springsecurity.entity.po.UserInfo;
import com.wei.demo_springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 82043
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUser")
    public UserInfo getUser(@RequestParam String username) {
        return userService.getUserByName(username);
    }

}

