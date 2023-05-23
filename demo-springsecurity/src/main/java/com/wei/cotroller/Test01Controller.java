package com.wei.cotroller;

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

}
