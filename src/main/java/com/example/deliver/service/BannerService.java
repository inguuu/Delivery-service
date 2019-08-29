package com.example.deliver.service;

import com.example.deliver.dto.CategoryList;
import com.example.deliver.model.DefaultRes;

import java.util.List;

public interface BannerService {

    DefaultRes<List<Banner>> getCategoryList(int categoryIdx);
}
