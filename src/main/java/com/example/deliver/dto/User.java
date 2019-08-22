package com.example.deliver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String userIdx;
    private String id;
    private String pw;
    private String name;
    private String address;
}
