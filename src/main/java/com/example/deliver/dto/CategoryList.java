package com.example.deliver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoryList {
    private int categoryId;
    private String categoryname;
    private int type;
}
