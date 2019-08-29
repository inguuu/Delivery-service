package com.example.deliver.api;

import com.example.deliver.model.DefaultRes;
import com.example.deliver.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping("/main/category/{categoryIdx}")
    public ResponseEntity getCategory(@PathVariable("categoryIdx") int categoryIdx) {
          log.info(categoryIdx+"");
        try {
            return new ResponseEntity<>(categoryService.getCategoryList(categoryIdx), HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
            DefaultRes<Object> ISR = new DefaultRes<>(HttpStatus.INTERNAL_SERVER_ERROR, "서버 내부 오류");
            return new ResponseEntity<>(ISR, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
}
