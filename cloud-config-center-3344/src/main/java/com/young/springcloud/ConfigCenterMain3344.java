package com.young.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Author LiuYang
 * @Date 2021/3/17 9:51
 */

@SpringBootApplication
@EnableConfigServer
public class ConfigCenterMain3344 {
    public static void main(String[] args) {

        SpringApplication.run(ConfigCenterMain3344.class);
    }
}