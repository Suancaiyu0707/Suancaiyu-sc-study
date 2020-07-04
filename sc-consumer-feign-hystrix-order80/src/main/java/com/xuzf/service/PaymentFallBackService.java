package com.xuzf.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallBackService implements PaymentHystrixService {
    public String paymentInfo_OK(Integer id) {
        return "PaymentFallBackService:"+"注解返回类";
    }

    public String paymentInfo_Timeout(Integer id) {
        return "PaymentFallBackService:"+"注解";
    }
}
