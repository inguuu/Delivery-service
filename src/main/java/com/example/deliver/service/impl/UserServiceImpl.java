package com.example.deliver.service.impl;

import com.example.deliver.dto.User;
import com.example.deliver.mapper.UserMapper;
import com.example.deliver.model.DefaultRes;
import com.example.deliver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;


    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public DefaultRes<User> signin(String id, String pw) {
        return null;
    }

    @Override
    public DefaultRes signup(User user) {
        userMapper.signup(user);
        return DefaultRes.res(HttpStatus.OK.value(), "등록 성공");
    }
}
