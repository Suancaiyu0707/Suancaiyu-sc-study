package com.xuzf.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author zhifang.xu
 * @CreateTime 2020/7/19 4:33 下午
 * @Version 1.0.0
 * @Desc
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private int id;
    private int productId;
    private int userId;
    private int count;
    private BigDecimal money;
    private String status;
}
