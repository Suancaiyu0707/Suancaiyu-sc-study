package com.xuzf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentNacosApp9004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentNacosApp9004.class,args);
    }
}
