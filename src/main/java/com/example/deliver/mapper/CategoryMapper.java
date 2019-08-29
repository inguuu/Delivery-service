package com.example.deliver.mapper;

import com.example.deliver.dto.CategoryList;
import com.example.deliver.dto.User;
import com.example.deliver.model.SigninReq;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Locale;

@Mapper
public interface CategoryMapper {

    @Select("SELECT * FROM Category JOIN CategoryList WHERE categoryIdx =#{category.idx} ")
    CategoryList getCategorylit(@Param("category") CategoryList categorylist);
}
