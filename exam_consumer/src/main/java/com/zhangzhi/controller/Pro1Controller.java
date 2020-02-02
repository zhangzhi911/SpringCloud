package com.zhangzhi.controller;

import com.zhangzhi.api.ControllerApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Pro1Controller {

    @Autowired
    private ControllerApi controllerApi;

    @RequestMapping("comment/list")
    public String list() {
        return controllerApi.list();
    }


}