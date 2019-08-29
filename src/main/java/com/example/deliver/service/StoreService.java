package com.example.deliver.service;

import com.example.deliver.dto.CategoryList;
import com.example.deliver.dto.Store;
import com.example.deliver.model.DefaultRes;

import java.util.List;

public interface StoreService {
    DefaultRes<List<Store>> getStoreList(int storeType);
}
