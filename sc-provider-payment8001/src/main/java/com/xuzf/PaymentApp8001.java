package com.xuzf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: zhifang.xu
 * @Date: 2020/5/23 5:34 下午
 * @Version: 1.0.0
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentApp8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApp8001.class,args);
    }
}
