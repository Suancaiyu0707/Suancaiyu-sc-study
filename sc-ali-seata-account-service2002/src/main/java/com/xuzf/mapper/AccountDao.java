package com.xuzf.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

@Mapper
public interface AccountDao {
    public void decrease(@Param("userId")Integer userId,@Param("money") BigDecimal money);
}
