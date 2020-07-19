package com.xuzf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentNacosApp9003 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentNacosApp9003.class,args);
    }
}
