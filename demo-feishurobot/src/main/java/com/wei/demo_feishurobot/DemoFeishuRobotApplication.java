package com.wei.demo_feishurobot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 82043
 */
@EnableFeignClients
@SpringBootApplication
public class DemoFeishuRobotApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoFeishuRobotApplication.class, args);
    }
}
