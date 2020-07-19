package com.xuzf.mapper;

import com.xuzf.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhifang.xu
 * @CreateTime 2020/7/19 4:46 下午
 * @Version 1.0.0
 * @Desc
 */
@Mapper
public interface OrderDao {
    void create(Order order);

    void update(@Param("userId") int userId, @Param("status")String status);
}
