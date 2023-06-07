package com.wei.demo_springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Security配置
 * @author 82043
 */
@EnableGlobalMethodSecurity(prePostEnabled=true)
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/js/**", "/css/**","/images/**","/test01/test01");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.authorizeRequests()
        //        .anyRequest().authenticated()
        //        .and()
        //        .formLogin()
        //        .loginPage("/login.html")
        //        .permitAll()
        //        .and()
        //        .csrf().disable();

        // 定义哪些URL需要被保护、哪些不需要被保护
        http.authorizeRequests()
                // 设置所有人都可以访问登录页面
                .antMatchers("/login").permitAll()
                // 任何请求,登录后可以访问
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login");
    }

}
