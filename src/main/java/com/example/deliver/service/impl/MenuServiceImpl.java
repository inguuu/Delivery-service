package com.example.deliver.service.impl;

import com.example.deliver.dto.CategoryList;
import com.example.deliver.dto.Menu;
import com.example.deliver.mapper.MenuMapper;
import com.example.deliver.model.DefaultRes;
import com.example.deliver.service.MenuService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    private final MenuMapper menuMapper;

    public MenuServiceImpl(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }

    @Override
    public DefaultRes<List<Menu>> getMenu(int storeIdx) {
        List<Menu> menulist = menuMapper.getMenulist(storeIdx);
        if (menulist.isEmpty()) {
            return DefaultRes.res(204, "등록된 메뉴가 없습니다.");
        } else {
            return DefaultRes.res(HttpStatus.OK.value(), "메뉴 조회 성공.",menulist);
        }
    }
}
