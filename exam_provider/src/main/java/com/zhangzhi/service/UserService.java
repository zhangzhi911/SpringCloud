package com.zhangzhi.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public String list(String pageNum, Integer pageSize) {
//        throw new RuntimeException("调用用户列表错误");
        return "用户列表: " + pageNum + ", " + pageSize;
    }
}