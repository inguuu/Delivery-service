package com.example.deliver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Store {
    private int storeIdx;
    private int storeType;
    private String storeName;
    private String storeImg;
    private String storeTime;
    private int storeReview;
}
