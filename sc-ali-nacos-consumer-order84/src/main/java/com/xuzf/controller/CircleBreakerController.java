package com.xuzf.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.xuzf.entities.CommonResult;
import com.xuzf.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class CircleBreakerController {
    @Value(("${service-url.nacos-payment-service}"))
    private String SERVICE_URL;
    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/fallback/{id}")
//    @SentinelResource(value = "fallback")   // 没有配置
//    @SentinelResource(value = "fallback",fallback = "handlerFallback")//fallback
    @SentinelResource(value = "fallback",blockHandler = "blockHandler")//blockhandler 针对的是Sentinel上配置的异常
//    @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler")//fallback+blockhandler
//    @SentinelResource(value = "fallback",fallback = "handlerFallback")
    //exceptionsToIgnore 用于指定排除的异常，会继续往外抛
    public CommonResult fallback(@PathVariable("id") Long id) {
        CommonResult result = restTemplate.getForObject(SERVICE_URL+"/payment/nacos/"+id,CommonResult.class,id);
        if (id==4){
            throw new IllegalArgumentException("IllegalArgumentException 非法参数异常");
        }else if(result.getData()==null){
            throw new NullPointerException("NullPointerException 无对应记录");
        }

        return result;
    }

    public CommonResult handlerFallback(@PathVariable Long id,Throwable e){
        return new CommonResult(500, id+"异常:"+e.getMessage());
    }

    public CommonResult blockHandler(Long id, BlockException e){
        return new CommonResult(500, id+" blocker异常");
    }

    @Resource
    private PaymentService paymentService;
    @GetMapping("consumer/payment/{id}")
    public CommonResult payment(@PathVariable("id") Integer id){
        return paymentService.payment(id);
    }
}
