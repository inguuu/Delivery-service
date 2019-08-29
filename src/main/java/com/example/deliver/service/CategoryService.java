package com.example.deliver.service;

import com.example.deliver.dto.CategoryList;
import com.example.deliver.model.DefaultRes;
import com.example.deliver.model.SigninReq;
import com.example.deliver.model.SigninRes;

import java.util.List;

public interface CategoryService {

    DefaultRes<List<CategoryList>> getCategoryList(CategoryList category);
}
