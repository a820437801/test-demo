package com.wei.demo_springsecurity.cotroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 82043
 */
@RestController
@RequestMapping("/test01")
public class Test01Controller {

    @GetMapping("/test01")
    public String test01() {
        return "ok";
    }

    public static void main(String[] args) {
        String url = "https://open.feishu.cn/open-apis/bot/v2/hook/de82cc47-a2cd-49f1-8a80-d0e68abc1280";

    }

}
