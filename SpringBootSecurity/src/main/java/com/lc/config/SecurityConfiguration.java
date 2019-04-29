package com.lc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by lc
 * createTime 2018/6/11.
 */
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    //HTTP请求安全处理
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
    }

    //网页安全
    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    //身份验证管理生成器
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("USER");
        super.configure(auth);
    }
}
