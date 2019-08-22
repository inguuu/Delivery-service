package com.example.deliver.service.impl;

import com.example.deliver.dto.User;
import com.example.deliver.mapper.UserMapper;
import com.example.deliver.model.DefaultRes;
import com.example.deliver.model.SigninReq;
import com.example.deliver.model.SigninRes;
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
    public DefaultRes<SigninRes> signin(SigninReq signinReq) {
        User user = userMapper.signin(signinReq);
        if(user==null) {
            return DefaultRes.res(204, "id나 패스워드가 틀렸습니다.");
        }else{
            SigninRes signinRes = new SigninRes(user.getUserIdx(),user.getAddress());

            return DefaultRes.res(HttpStatus.OK.value(), "로그인 성공",signinRes);
        }

    }

    @Override
    public DefaultRes signup(User user) {
        userMapper.signup(user);
        return DefaultRes.res(HttpStatus.OK.value(), "회원가입 성공");
    }
}
