package com.young.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 通过编码配置
 * @Author LiuYang
 * @Date 2021/3/15 15:09
 */
@Configuration
public class GateWayConfig {


    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {

        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        routes.route("path_route_young",r->r.path("/guonei").uri("http://news.baidu.com/guonei")).build();

        return routes.build();
    }
}
