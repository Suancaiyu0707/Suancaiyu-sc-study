package com.xuzf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: zhifang.xu
 * @Date: 2020/5/23 3:32 下午
 * @Version: 1.0.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderApp82 {
    public static void main(String[] args) {
        SpringApplication.run(OrderApp82.class,args);
    }
}
