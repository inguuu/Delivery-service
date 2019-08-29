package com.example.deliver.service;

import com.example.deliver.dto.Menu;
import com.example.deliver.model.DefaultRes;

import java.util.List;

public interface MenuService {
    DefaultRes<List<Menu>> getMenu(int storeIdx);
}
