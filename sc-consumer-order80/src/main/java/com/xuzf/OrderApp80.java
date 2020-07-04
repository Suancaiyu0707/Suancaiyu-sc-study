package com.xuzf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: zhifang.xu
 * @Date: 2020/5/23 3:32 下午
 * @Version: 1.0.0
 */
@SpringBootApplication
@EnableEurekaClient
public class OrderApp80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderApp80.class,args);
    }
}
