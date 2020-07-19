package com.xuzf.controller;

import com.xuzf.entities.CommonResult;
import com.xuzf.mapper.AccountDao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RestController
public class AccountController {
    @Resource
    AccountDao accountMapper;

    @RequestMapping("/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Integer userId, @RequestParam("money") BigDecimal money){
        accountMapper.decrease(userId,money);
        return new CommonResult(200,"account decrease success") ;
    }
}
