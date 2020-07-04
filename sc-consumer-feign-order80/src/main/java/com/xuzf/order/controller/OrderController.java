package com.xuzf.order.controller;

import com.xuzf.entities.CommonResult;
import com.xuzf.entities.Payment;
import com.xuzf.order.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhifang.xu
 * @CreateTime 2020/6/3 12:17 上午
 * @Version 1.0.0
 * @Desc
 */
@RestController
public class OrderController {

    @Resource
    private PaymentFeignService paymentFeignService;
    /***
     * 获得注册的服务列表
     */

    @GetMapping("/consumer/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/consumer/paymentTimeout")
    public String paymentTimeout(){
        return paymentFeignService.paymentTimeout();
    }
}
