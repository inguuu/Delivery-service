package com.example.deliver.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SigninRes {
    private String userIdx;
    private String address;
}