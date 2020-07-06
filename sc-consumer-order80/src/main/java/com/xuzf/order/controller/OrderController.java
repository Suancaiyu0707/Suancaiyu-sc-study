package com.xuzf.order.controller;


import com.xuzf.entities.CommonResult;
import com.xuzf.entities.Payment;
import com.xuzf.lb.OrderLoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @Author: zhifang.xu
 * @Date: 2020/5/23 3:33 下午
 * @Version: 1.0.0
 */
@RestController
public class OrderController {

    public static final String PAYMENT_URL = "http://SC-PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private OrderLoadBalancer orderLoadBalancer;

    /***
     * 获得注册的服务列表
     */
    @Resource
    public DiscoveryClient discoveryClient;
    @PostMapping("/payment/create")
    public CommonResult<Payment> create(Payment payment){

        return restTemplate.postForObject(PAYMENT_URL +"/payment/create",payment,CommonResult.class);
    }
    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL +"/payment/getPaymentById/"+id,CommonResult.class);
    }
    @GetMapping("/payment/lb")
    public String getPaymentLB(){
        List<ServiceInstance> serviceInstanceList =discoveryClient.getInstances("SC-PAYMENT-SERVICE");
        if(serviceInstanceList==null||serviceInstanceList.size()<=0){
            return null;
        }
        ServiceInstance instance = orderLoadBalancer.instances(serviceInstanceList);

        URI uri = instance.getUri();

        return restTemplate.getForObject(uri+"/payment/lb",String.class);
    }
    @GetMapping("/payment/zipkin")
    public String paymentZipkin(){
        String result = restTemplate.getForObject(PAYMENT_URL+"/payment/zipkin",String.class);
        return result;
    }
}
