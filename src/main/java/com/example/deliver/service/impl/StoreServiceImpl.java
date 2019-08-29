package com.example.deliver.service.impl;

import com.example.deliver.dto.CategoryList;
import com.example.deliver.dto.Store;
import com.example.deliver.mapper.StoreMapper;
import com.example.deliver.model.DefaultRes;
import com.example.deliver.service.StoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class StoreServiceImpl implements StoreService {
    private final StoreMapper storeMapper;

    public StoreServiceImpl(StoreMapper storeMapper) {
        this.storeMapper = storeMapper;
    }

    @Override
    public DefaultRes<List<Store>> getStoreList(int storeType) {
        List<Store> storelist = storeMapper .getStorelist(storeType);
        if (storelist.isEmpty()) {
            return DefaultRes.res(204, "가게가 없습니다.");
        } else {
            return DefaultRes.res(HttpStatus.OK.value(), "가게 조회 성공.",storelist);
        }
    }
}
