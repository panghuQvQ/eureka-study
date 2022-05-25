package com.wang.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author wzy
 * @version 1.0.0
 * @ClassName WebSecurityConfig.java
 * @Description 安全认证配置类
 * @createTime 2022年05月11日 16:29:00
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    保持密码验证的同时禁用CSRF防御机制
//    @Override
//    protected void configure(HttpSecurity http) throws Exception{
//        super.configure(http); // 加这句话是为了访问eureka控制台和 /actuator 时能做安全控制
//        http.csrf().ignoringAntMatchers("/eureka/**"); // 忽略 /eureka/** 的所有请求
//    }

    // 保持密码验证的同时禁用CSRF防御机制
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        // 注意，如果直接disable的话会把安全验证也禁用掉
        http.csrf().disable().authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }
}
