package com.xuzf.controller;

import com.xuzf.domain.Order;
import com.xuzf.entities.CommonResult;
import com.xuzf.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhifang.xu
 * @CreateTime 2020/7/19 5:38 下午
 * @Version 1.0.0
 * @Desc
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @PostMapping("/order/create")
    public CommonResult createOrder(@RequestBody Order order){
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }
}
