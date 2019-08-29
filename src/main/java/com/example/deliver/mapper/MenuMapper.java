package com.example.deliver.mapper;

import com.example.deliver.dto.CategoryList;
import com.example.deliver.dto.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MenuMapper {
    @Select("SELECT * FROM Menu WHERE storeIdx = #{storeIdx}")
    List<Menu> getMenulist(@Param("storeIdx") int storeIdx);
}
