package com.zhangzhi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.zhangzhi.Mapper")
public class Provider2Application {
    public static void main(String[] args) {
        SpringApplication.run(Provider2Application.class);
    }
}