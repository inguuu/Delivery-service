package com.example.deliver.service;



import com.example.deliver.dto.User;
import com.example.deliver.model.DefaultRes;
import com.example.deliver.model.SigninReq;
import com.example.deliver.model.SigninRes;

import java.util.List;

public interface UserService {

    DefaultRes<SigninRes> signin(SigninReq signinReq);
    DefaultRes signup(User user);

}
