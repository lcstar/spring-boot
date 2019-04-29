package com.lc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableWebSecurity
@MapperScan("com.lc.mapper")
public class SecurityApplication {
//https://www.cnblogs.com/softidea/p/7068149.html
	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}
}
