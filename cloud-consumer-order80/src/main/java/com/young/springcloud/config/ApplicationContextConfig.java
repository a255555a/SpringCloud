package com.young.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author LiuYang
 * @Date 2021/3/10 13:56
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
//    @LoadBalanced //为了试验自己写的rule
    //使用@LoadBalanced注解赋予RestTemplate负载均衡的能力
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
