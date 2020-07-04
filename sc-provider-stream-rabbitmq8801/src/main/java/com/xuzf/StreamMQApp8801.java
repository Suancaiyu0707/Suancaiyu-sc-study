package com.xuzf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StreamMQApp8801 {
    public static void main(String[] args) {
        SpringApplication.run(StreamMQApp8801.class,args);
    }
}
