package com.xuzf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhifang.xu
 * @CreateTime 2020/7/12 12:09 上午
 * @Version 1.0.0
 * @Desc
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ScAliSentinelApp8401 {
    public static void main(String[] args) {
        SpringApplication.run(ScAliSentinelApp8401.class,args);
    }
}
