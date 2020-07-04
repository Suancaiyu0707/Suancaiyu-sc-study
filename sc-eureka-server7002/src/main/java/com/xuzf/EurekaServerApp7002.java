package com.xuzf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: zhifang.xu
 * @Date: 2020/5/23 4:54 下午
 * @Version: 1.0.0
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApp7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApp7002.class,args);
    }
}
