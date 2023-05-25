package com.wei.cotroller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 用来跳转
 * 到登录页
 * @author 82043
 */
@Controller
public class LoginController {

    @GetMapping("/login")
    public String toLogin() {
        return "login";
    }

}
