package com.xuzf.order.service;

import com.xuzf.entities.CommonResult;
import com.xuzf.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zhifang.xu
 * @CreateTime 2020/6/3 12:13 上午
 * @Version 1.0.0
 * @Desc
 */
@Component
@FeignClient(value = "SC-PAYMENT-SERVICE")//value指定在注册中心上注册的服务名
public interface PaymentFeignService {

    @GetMapping("/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/payment/paymentTimeout")
    String paymentTimeout();
}
