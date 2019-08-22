package com.example.deliver.mapper;

import com.example.deliver.dto.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Insert("INSERT INTO User(id,pw,name,address) VALUES(#{user.id},#{user.pw},#{user.name},#{user.address})")
    void signup(@Param("user") User user);

    @Select("SELECT * FROM User WHERE String =#{id}")
    User signin(@Param("id") String id);
}
