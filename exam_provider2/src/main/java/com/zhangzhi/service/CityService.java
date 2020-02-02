package com.zhangzhi.service;


import com.zhangzhi.Mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    @Autowired
    private CityMapper cityMapper;

    public int testcount() {
        return cityMapper.testcount();
    }


}
