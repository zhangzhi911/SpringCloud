package com.zhangzhi.controller;

import com.netflix.discovery.converters.Auto;
import com.zhangzhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Pro1Controller {

    @RequestMapping("list")
    public String list() {
        System.out.println("来了pro1");
        return "来了老弟?这里是pro1";
    }

    @Autowired
    private UserService userService;

    @RequestMapping("coment/list")
    public String list2() {
        return userService.list("1",2);
    }


}