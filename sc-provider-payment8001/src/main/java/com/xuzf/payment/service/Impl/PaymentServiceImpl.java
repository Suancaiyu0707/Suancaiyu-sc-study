package com.xuzf.payment.service.Impl;

import com.xuzf.entities.Payment;
import com.xuzf.payment.dao.PaymentDao;
import com.xuzf.payment.service.IPaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: zhifang.xu
 * @Date: 2020/5/23 2:56 下午
 * @Version: 1.0.0
 */
@SuppressWarnings("ALL")
@Service
public class PaymentServiceImpl implements IPaymentService {
    @Resource
    public PaymentDao paymentDao;
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
