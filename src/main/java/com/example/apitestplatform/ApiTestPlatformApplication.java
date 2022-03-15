package com.example.apitestplatform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.apitestplatform.mapper")
public class ApiTestPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiTestPlatformApplication.class, args);
    }

}
