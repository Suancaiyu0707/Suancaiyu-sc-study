package com.xuzf.service;

import com.xuzf.entities.CommonResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author zhifang.xu
 * @CreateTime 2020/7/19 5:05 下午
 * @Version 1.0.0
 * @Desc
 */
@FeignClient(value = "sc-ali-seata-account-service")
public interface AccountService {
    //扣钱
    @PostMapping("/account/decrease")
    CommonResult decrease(@RequestParam("userId") Integer productId,@RequestParam("money") BigDecimal money);
}
