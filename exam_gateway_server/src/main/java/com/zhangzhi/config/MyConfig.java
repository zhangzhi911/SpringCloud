package com.zhangzhi.config;//package com.zhangzhi.config;
//
//
//import com.zhangzhi.filter.MyGateWayFilter;
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//
//@Component
//public class MyConfig {
//
//    @Bean
//    public RouteLocator getRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
//        RouteLocatorBuilder.Builder route = routeLocatorBuilder.routes().route(
//                r -> r.path("/api/client/**")
//                        .filters(f -> f.stripPrefix(2).filter(getMyFilter()))
//                        .uri("http://localhost:10001")
//                        .order(0)
//                        .id("mall-provider")
//
//        );
//
//        return route.build();
//    }
//
//    @Bean
//    public MyGateWayFilter getMyFilter() {
//        return new MyGateWayFilter();
//    }
//
//}
