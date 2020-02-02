package com.zhangzhi.api;

import org.springframework.stereotype.Component;

@Component
public class ApiHander implements ControllerApi {
    @Override
    public String list() {
        return "报错了弟弟";
    }
}