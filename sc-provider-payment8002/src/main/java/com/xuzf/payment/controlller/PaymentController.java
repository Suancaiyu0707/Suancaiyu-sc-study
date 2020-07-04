package com.xuzf.payment.controlller;

import com.xuzf.entities.CommonResult;
import com.xuzf.entities.Payment;
import com.xuzf.payment.service.IPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: zhifang.xu
 * @Date: 2020/5/23 2:59 下午
 * @Version: 1.0.0
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    public IPaymentService paymentService;

    /***
     * 获得注册的服务列表
     */
    @Resource
    public DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;
    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        log.info("Server.port="+serverPort);
        int result = paymentService.create(payment);
        if(result>0){
            return new CommonResult(200,"添加成功,serverPort="+serverPort);
        }else{
            return new CommonResult(500,"添加失败,serverPort="+serverPort);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        log.info("Server.port="+serverPort);
        Payment result = paymentService.getPaymentById(id);
        if(result!=null){
            return new CommonResult(200,"查询成功,serverPort="+serverPort,result);
        }else{
            return new CommonResult(500,"查询失败,serverPort="+serverPort,null);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        List<ServiceInstance> serviceInstanceList =discoveryClient.getInstances("SC-PAYMENT-SERVICE");
        for(ServiceInstance instance:serviceInstanceList){
            log.info("instance = "+instance.getInstanceId()+", host = "+instance.getHost()+", port = "+instance.getPort());
        }
        return  services;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }

    @GetMapping("/payment/paymentTimeout")
    public String paymentTimeout(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
