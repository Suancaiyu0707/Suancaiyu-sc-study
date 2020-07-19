package com.xuzf.controller;

import com.xuzf.entities.CommonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Integer,String> hashMap = new HashMap<>();
    static {
        hashMap.put(1,"id=1");
        hashMap.put(2,"id=2");
        hashMap.put(3,"id=3");
    }
    @GetMapping(value = "/payment/nacos/{id}")
    public CommonResult getPayment(@PathVariable("id") Integer id){
        String result =  hashMap.get(id)+" 端口号："+serverPort;
        return new CommonResult(200,"",result);
    }
}
