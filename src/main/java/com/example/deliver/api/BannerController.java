package com.example.deliver.api;

import com.example.deliver.service.BannerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class BannerController {

    private final BannerService bannerService;

    public BannerController(BannerService bannerService) {
        this.bannerService = bannerService;
    }

    @GetMapping("/banner")
    public ResponseEntity getBanner() {

        return new ResponseEntity<>(bannerService.getBanner(), HttpStatus.OK);

    }
}
