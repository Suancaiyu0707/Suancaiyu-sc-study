package com.xuzf.order.controller;


import com.xuzf.entities.CommonResult;
import com.xuzf.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author: zhifang.xu
 * @Date: 2020/5/23 3:33 下午
 * @Version: 1.0.0
 */
@RestController
public class OrderController {
    //zookeeper上的地址
    public static final String PAYMENT_URL = "http://sc-payment-service-zookeeper";
    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/payment/create")
    public CommonResult<Payment> create(Payment payment){

        return restTemplate.postForObject(PAYMENT_URL +"/payment/create",payment,CommonResult.class);
    }
    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL +"/payment/getPaymentById/"+id,CommonResult.class);
    }

}
