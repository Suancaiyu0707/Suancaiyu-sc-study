package com.xuzf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zhifang.xu
 * @CreateTime 2020/6/3 12:11 上午
 * @Version 1.0.0SC-PAYMENT-SERVICE
 * @Desc
 */
@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
public class OrderHystrixApp80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixApp80.class,args);
    }
}
