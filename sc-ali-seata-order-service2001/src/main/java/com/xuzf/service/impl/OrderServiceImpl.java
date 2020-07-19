package com.xuzf.service.impl;

import com.xuzf.domain.Order;
import com.xuzf.mapper.OrderDao;
import com.xuzf.service.AccountService;
import com.xuzf.service.OrderService;
import com.xuzf.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhifang.xu
 * @CreateTime 2020/7/19 5:07 下午
 * @Version 1.0.0
 * @Desc
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;
    @GlobalTransactional
    @Override
    public void create(Order order) {
        log.info("========begin create order========");
        orderDao.create(order);
        log.info("========开始调用账户服务扣钱    accountService ========");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("========开始调用库存服务扣库存   storageService ========");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("========end create order========");
        orderDao.update(order.getUserId(),"1");
    }

    @Override
    public void update(int userId, String status) {

    }
}
