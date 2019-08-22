package com.example.deliver.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SigninReq {
    private String id;
    private String pw;
}
