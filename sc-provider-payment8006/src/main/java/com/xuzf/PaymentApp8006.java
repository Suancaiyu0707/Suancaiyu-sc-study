package com.xuzf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: zhifang.xu
 * @Date: 2020/5/23 5:34 下午
 * @Version: 1.0.0
 */
@SpringBootApplication
@EnableDiscoveryClient//该注解用于向使用consul或者zookeeper作为注册中心时注册服务
public class PaymentApp8006 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApp8006.class,args);
    }
}
