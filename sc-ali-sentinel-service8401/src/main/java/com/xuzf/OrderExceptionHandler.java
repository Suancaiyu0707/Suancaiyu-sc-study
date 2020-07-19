package com.xuzf;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.xuzf.entities.CommonResult;

/**
 * @author zhifang.xu
 * @CreateTime 2020/7/15 9:14 下午
 * @Version 1.0.0
 * @Desc
 */
public class OrderExceptionHandler {
    /**
     * 这里方法必须是static
     * @param e
     * @return
     */
    public static CommonResult handler1(BlockException e) {
        return new CommonResult(444,"我是handler1，降级到我这边来了");
    }
    public static CommonResult handler2(BlockException e) {
        return new CommonResult(444,"我是handler2，降级到我这边来了");
    }
}
