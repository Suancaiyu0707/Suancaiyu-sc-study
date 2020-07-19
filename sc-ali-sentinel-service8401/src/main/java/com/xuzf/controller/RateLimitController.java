package com.xuzf.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.xuzf.ExceptionHandler;
import com.xuzf.OrderExceptionHandler;
import com.xuzf.entities.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class  RateLimitController {
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handlerException")
    public CommonResult byResource(){
        return new CommonResult(200,"资源 byResource");
    }
    public  CommonResult handlerException(BlockException e){
        System.out.println("111111");
        return new CommonResult(444,"服务降级不可用");
    }

    @GetMapping("/byUrl")
    @SentinelResource("byUrl")
    public CommonResult byUrl(){
        return new CommonResult(200,"资源 byUrl");
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "rateLimit",blockHandlerClass = OrderExceptionHandler.class,blockHandler = "handler1")
    public CommonResult byOrderHandler(){
        return new CommonResult(200,"资源 byUrl");
    }

}
