package com.example.deliver.mapper;

import com.example.deliver.dto.Banner;
import com.example.deliver.dto.CategoryList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BannerMapper {
    @Select("SELECT * FROM Banner")
    List<Banner> getBanner();
}
