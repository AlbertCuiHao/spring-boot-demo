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
        /*
         * Banner.Mode.OFF:关闭;
         * Banner.Mode.CONSOLE:控制台输出，默认方式;
         * Banner.Mode.LOG:日志输出方式;
         */
        application.setBannerMode(Banner.Mode.CONSOLE);
        application.run(args);
    }

}
