package com.example.deliver.service.impl;

import com.example.deliver.dto.Banner;
import com.example.deliver.mapper.BannerMapper;
import com.example.deliver.model.DefaultRes;
import com.example.deliver.service.BannerService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {
    private  final BannerMapper bannerMapper;

    public BannerServiceImpl(BannerMapper bannerMapper) {
        this.bannerMapper = bannerMapper;
    }

    @Override
    public DefaultRes<List<Banner>> getBanner() {
        List<Banner> bannerList = bannerMapper.getBanner();
        if (bannerList.isEmpty()) {
            return DefaultRes.res(204, "배너가 없습니다.");
        } else {
            return DefaultRes.res(HttpStatus.OK.value(), "배너 조회 성공.",bannerList);
        }
    }
}
