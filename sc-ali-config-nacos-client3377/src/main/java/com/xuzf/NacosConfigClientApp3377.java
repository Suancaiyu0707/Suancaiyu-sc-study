package com.xuzf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosConfigClientApp3377 {
    public static void main(String[] args) {
        SpringApplication.run(NacosConfigClientApp3377.class,args);
    }
}
