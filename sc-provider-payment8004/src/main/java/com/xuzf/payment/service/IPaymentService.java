package com.xuzf.payment.service;

import com.xuzf.entities.Payment;

/**
 * @Author: zhifang.xu
 * @Date: 2020/5/23 2:55 下午
 * @Version: 1.0.0
 */
public interface IPaymentService {

    int create(Payment payment);

    Payment getPaymentById(Long id);

}
