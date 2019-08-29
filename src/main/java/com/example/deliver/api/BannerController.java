package com.example.deliver.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class BannerController {

    @GetMapping("/banner")
    public ResponseEntity getBanner() {

        return new ResponseEntity<>(, HttpStatus.OK);

    }
}
