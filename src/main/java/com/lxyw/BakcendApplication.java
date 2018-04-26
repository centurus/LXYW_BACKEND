package com.lxyw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.lxyw.dao")
public class BakcendApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {

        SpringApplication.run(BakcendApplication.class, args);
    }
}
