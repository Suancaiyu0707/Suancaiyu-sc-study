package com.xuzf.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.xuzf.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@DefaultProperties(defaultFallback ="paymentGlobalFallBack" ) //指明默认的全局的fallback
public class OrderController {
    @Resource
    private PaymentHystrixService service;

    @GetMapping("/consumer/ok/{id}")
    public String paymentInfo_OK(@PathVariable Integer id) {
        return service.paymentInfo_OK(id);
    }

    /***
     * 这边是客户端兜底方案，通常也是在客户端做兜底
     * 设置超过 3 秒采用服务降级(小于服务端的超时时间5秒)
     *
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
            //客户端自己定义了超时时间，和服务端的超时时间是独立的
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    })
    @GetMapping("/consumer/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable Integer id) {
//         int a= 10/0;
        return service.paymentInfo_Timeout(id);
    }

    public String paymentInfo_TimeoutHandler(Integer id){
        return "我是消费者80，线程池："+Thread.currentThread().getName()+" 特定的服务降级：对方系统繁忙或者我自己运行错误，请稍后再试😭";

    }

    // 下面是全局 fallback
    public String paymentGlobalFallBack(){
        return "我是消费者80，线程池："+Thread.currentThread().getName()+" 全局服务降级方案：对方系统繁忙或者运行错误，请稍后再试😭";
    }
}
