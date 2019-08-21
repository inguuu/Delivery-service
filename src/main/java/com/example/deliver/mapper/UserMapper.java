package com.example.deliver.mapper;

import com.example.deliver.dto.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    @Insert("INSERT INTO User(id,pw,name) VALUES(#{user.id},#{user.pw},#{user.name})")
    void signup(@Param("user") User user);
}
