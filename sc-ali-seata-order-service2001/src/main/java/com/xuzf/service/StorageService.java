package com.xuzf.service;

import com.xuzf.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zhifang.xu
 * @CreateTime 2020/7/19 5:06 下午
 * @Version 1.0.0
 * @Desc
 */
//调用远程服务
@FeignClient(value = "sc-ali-seata-storage-service")
public interface StorageService {
    //扣掉库存
    @PostMapping("/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Integer productId, @RequestParam("count") Integer count);

}
