package com.example.deliver.mapper;

import com.example.deliver.dto.CategoryList;
import com.example.deliver.dto.User;
import com.example.deliver.model.SigninReq;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Locale;

@Mapper
public interface CategoryMapper {

    @Select("SELECT * FROM CategoryList WHERE categoryId = #{categoryId}")
    List<CategoryList> getCategorylist(@Param("categoryId") int categoryIdx);
}
