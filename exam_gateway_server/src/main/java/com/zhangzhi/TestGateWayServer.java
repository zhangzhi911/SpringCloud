package com.zhangzhi;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * GateWayServer的启动类
 */
@SpringBootApplication
@RestController
public class TestGateWayServer {

    public static void main(String[] args) {
        SpringApplication.run(TestGateWayServer.class);
    }

    @RequestMapping("/serverhealth1")
    public String serverhealth1() {
        return "来了";
    }

}