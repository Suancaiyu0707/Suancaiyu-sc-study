package com.xuzf.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StorageDao {
    public void decrease(@Param("productId") Integer productId,@Param("count") Integer count);
}
