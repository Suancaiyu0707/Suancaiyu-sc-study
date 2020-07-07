package com.xuzf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@SpringBootApplication
@EnableDiscoveryClient
public class AliPaymentApp9001 {
    public static void main(String[] args) {
        SpringApplication.run(AliPaymentApp9001.class,args);
    }
}
