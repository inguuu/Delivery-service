package com.example.deliver.api;

import com.example.deliver.model.DefaultRes;
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
       try{
            return new ResponseEntity<>(bannerService.getBanner(), HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
            DefaultRes<Object> ISR = new DefaultRes<>(HttpStatus.INTERNAL_SERVER_ERROR, "서버 내부 오류");
            return new ResponseEntity<>(ISR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
