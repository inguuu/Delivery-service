package com.example.deliver.service;



import com.example.deliver.dto.User;
import com.example.deliver.model.DefaultRes;

import java.util.List;

public interface UserService {

    DefaultRes<User> signin(String id,String pw);
    DefaultRes signup(User user);



}
