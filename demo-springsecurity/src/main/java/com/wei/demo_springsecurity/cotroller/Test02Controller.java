package com.wei.demo_springsecurity.cotroller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 82043
 */
@RestController
@RequestMapping("/test02")
public class Test02Controller {

    @PreAuthorize("hasAnyRole('beijingAdmin')")
    @GetMapping("/test01")
    public String test01() {
        return "ok";
    }

    @PreAuthorize("hasAnyRole('user')")
    @GetMapping("/test02")
    public String test02() {
        return "ok";
    }

    @PreAuthorize("hasAnyRole('aaa')")
    @GetMapping("/test03")
    public String test03() {
        return "ok";
    }

}
