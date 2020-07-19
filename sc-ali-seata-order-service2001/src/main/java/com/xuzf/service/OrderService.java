package com.xuzf.service;

import com.xuzf.domain.Order;
import org.springframework.stereotype.Service;

/**
 * @author zhifang.xu
 * @CreateTime 2020/7/19 4:52 下午
 * @Version 1.0.0
 * @Desc
 */
public interface OrderService {
    void create(Order order);

    void update(int userId,String status);
}
