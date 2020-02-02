package com.zhangzhi.controller;


import com.zhangzhi.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope  //刷新
public class Pro2Controller {

    @Autowired
    private CityService userService;

    @RequestMapping("list")
    public String list() {
        System.out.println("来了pro2");
        return "来了老弟?这里是pro2" + userService.testcount();
//        throw new RuntimeException();
    }
}