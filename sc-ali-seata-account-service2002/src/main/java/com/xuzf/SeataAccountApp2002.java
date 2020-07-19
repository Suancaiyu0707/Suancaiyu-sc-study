package com.xuzf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zhifang.xu
 * @CreateTime 2020/7/19 5:26 下午
 * @Version 1.0.0
 * @Desc
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)//取消数据源自动装配
public class SeataAccountApp2002 {
    public static void main(String[] args) {
        SpringApplication.run(SeataAccountApp2002.class,args);
    }
}
