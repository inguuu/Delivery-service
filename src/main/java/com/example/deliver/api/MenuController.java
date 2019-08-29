package com.example.deliver.api;

import com.example.deliver.model.DefaultRes;
import com.example.deliver.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/menu/{storeIdx}")
    public ResponseEntity getMenu(@PathVariable("storeIdx") int storeIdx){
        try {
            return new ResponseEntity<>(menuService.getMenu(storeIdx), HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
            DefaultRes<Object> ISR = new DefaultRes<>(HttpStatus.INTERNAL_SERVER_ERROR, "서버 내부 오류");
            return new ResponseEntity<>(ISR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
