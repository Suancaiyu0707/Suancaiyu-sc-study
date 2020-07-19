package com.xuzf.controller;

import com.xuzf.entities.CommonResult;
import com.xuzf.mapper.StorageDao;
import io.seata.core.context.RootContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
public class StorageController {
    @Resource
    StorageDao storageMapper;

    @RequestMapping("/storage/decrease")
    public CommonResult decrease(@RequestParam("productId") Integer productId, @RequestParam("count") Integer count) throws InterruptedException {
        System.out.println("全局事务id:{}"+RootContext.getXID());
//        Thread.sleep(20000);
        storageMapper.decrease(productId,count);
        return new CommonResult(200,"storage decrease success") ;
    }
}
