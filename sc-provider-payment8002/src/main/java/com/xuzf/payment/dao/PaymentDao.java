package com.xuzf.payment.dao;

import com.xuzf.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: zhifang.xu
 * @Date: 2020/5/23 2:45 下午
 * @Version: 1.0.0
 */
@Mapper
public interface PaymentDao {
    int create(Payment payment);

    Payment getPaymentById(Long id);
}
