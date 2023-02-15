package com.albert.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.albert"})
@MapperScan({"com.albert.auth.mapper"})
public class AuthApiApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(AuthApiApplication.class);
        application.setBannerMode(Banner.Mode.CONSOLE);
        application.run(args);
    }

}
