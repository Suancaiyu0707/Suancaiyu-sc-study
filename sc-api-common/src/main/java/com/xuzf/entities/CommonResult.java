package com.xuzf.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: zhifang.xu
 * @Date: 2020/5/23 2:43 下午
 * @Version: 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> implements Serializable {

    private Integer code;

    private String msg;

    private T data;

    public CommonResult(Integer code,String msg){
        this(code,msg,null);
    }
}
