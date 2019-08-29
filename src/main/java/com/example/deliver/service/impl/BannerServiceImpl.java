package com.example.deliver.service.impl;

import com.example.deliver.dto.Banner;
import com.example.deliver.mapper.BannerMapper;
import com.example.deliver.model.DefaultRes;
import com.example.deliver.service.BannerService;
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
        List<BannerMapper> bannerList = bannerMapper.getBanner();
    }
}
