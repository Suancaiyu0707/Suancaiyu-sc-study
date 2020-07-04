package com.xuzf.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
//value是服务端的实例的名称
/***
 * fallback：是客户端的降级兜底方案，和服务端的兜底方案是独立的
 * value：定义代理的微服务，这样可以调用这个被代理的微服务的所有方法
 * fallback：指定当这个代理的微服务调用出现异常时，要进行降级的方案的服务(这样就不用指定了HystrixCommand)
 */
@FeignClient(value = "SC-PAYMENT-HYSTRIX-SERVICE",fallback = PaymentFallBackService.class)
public interface PaymentHystrixService {
    @GetMapping("/ok/{id}")
    public String paymentInfo_OK(@PathVariable(value = "id") Integer id);

    @GetMapping("/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable(value = "id") Integer id);
}
