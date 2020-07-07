package com.xuzf;

/**
 * @author zhifang.xu
 * @CreateTime 2020/7/7 12:28 上午
 * @Version 1.0.0
 * @Desc
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@SpringBootApplication
@EnableDiscoveryClient
public class AliPaymentApp9002 {
    public static void main(String[] args) {
        SpringApplication.run(AliPaymentApp9002.class,args);
    }
}
