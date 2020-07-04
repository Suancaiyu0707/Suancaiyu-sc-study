package com.xuzf.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {
    public String paymentInfo_OK(Integer id){
        return "线程池："+Thread.currentThread().getName()+"  paymentInfo_OK,id "+id+"\t"+"哈哈😊";
    }

    // 设置超过 3 秒采用服务降级

    /**
     * fallbackMethod：兜底类，会对超时、运行异常都会通过这个方法进行兜底
     * execution.isolation.thread.timeoutInMilliseconds：指定兜底的超时是时间
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
            //指定这个线程的超时时间是3秒，3秒以内走正常，超过3秒走兜底方法paymentInfo_TimeoutHandler
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000")
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "10000")
    })
    public String paymentInfo_Timeout(Integer id){
//        int a = 10/0;
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+"  paymentInfo_Timeout，id: "+id+"\t"+"哈哈😊，耗时 5s";
    }

    /***
     * 作为paymentInfo_Timeout的兜底方案
     * @param id
     * @return
     */
    public String paymentInfo_TimeoutHandler(Integer id){
        return "线程池："+Thread.currentThread().getName()+" 服务降级：系统繁忙或者运行错误，呜呜😭";
    }
//
    // 服务熔断
        @HystrixCommand(fallbackMethod = "paymentInfo_Circuit",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),// 请求次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),// 时间窗口期
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60")// 失败率达到多少后跳闸
            // 加起来就是在10s内的超过10次请求中且如果失败率超过百分之60，则进入服务熔断
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if (id<0){
            throw new RuntimeException("***id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return "调用成功："+serialNumber;
    }

    public String paymentInfo_Circuit(Integer id){
        return "***id不能为负数："+id+" ，打开断路器";
    }
}
