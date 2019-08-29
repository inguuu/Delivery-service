package com.example.deliver.mapper;

import com.example.deliver.dto.CategoryList;
import com.example.deliver.dto.Store;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StoreMapper {

    @Select("SELECT * FROM Store WHERE storeType = #{storeType}")
    List<Store> getStorelist(@Param("storeType") int storeType);
}
