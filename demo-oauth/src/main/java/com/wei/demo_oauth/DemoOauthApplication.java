package com.wei.demo_oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @author 82043
 */
@EnableAuthorizationServer
@EnableResourceServer
@SpringBootApplication
public class DemoOauthApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoOauthApplication.class, args);
    }
}
