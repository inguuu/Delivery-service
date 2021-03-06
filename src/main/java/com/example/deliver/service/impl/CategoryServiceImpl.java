package com.example.deliver.service.impl;

import com.example.deliver.dto.CategoryList;
import com.example.deliver.mapper.CategoryMapper;
import com.example.deliver.model.DefaultRes;
import com.example.deliver.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }


    @Override
    public DefaultRes<List<CategoryList>> getCategoryList(int categoryIdx) {

        log.info(categoryMapper.getCategorylist(categoryIdx)+"==================");
        List<CategoryList> categoryList = categoryMapper.getCategorylist(categoryIdx);
        if (categoryList.isEmpty()) {
            return DefaultRes.res(204, "카테고리가 없습니다.");
        } else {
            return DefaultRes.res(HttpStatus.OK.value(), "카테고리 조회 성공.",categoryList);
        }

    }
}
