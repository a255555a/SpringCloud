package com.young.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @Author LiuYang
 * @Date 2021/3/15 16:37
 */
@Component
@Slf4j
public class MyLogGateWayFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        log.info("------------ come in MyLogGateWayFilter: " + new Date());
        String uName = exchange.getRequest().getQueryParams().getFirst("uName");
        if (StringUtils.isEmpty(uName)) {
            log.info("------------ 用户名 [{}] 非法 o(╥﹏╥)o", uName);
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);

    }

    @Override
    public int getOrder() {
        return 0;
    }
}