package com.example.deliver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Menu {
    private int storeIdx;
    private String menuIng;
    private String menuName;
    private String menuPrice;
}
