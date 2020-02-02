package com.zhangzhi.api;

import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "eureka-provider",fallback = ApiHander.class)
//@Hystrix  //熔断注解
@EnableCircuitBreaker  //熔断注解
public interface ControllerApi {
    @RequestMapping("/list")
    public String list();
}