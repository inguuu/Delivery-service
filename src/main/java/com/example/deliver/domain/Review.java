package com.example.deliver.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "review")
public class Review {
    @Id
    private  int reviewIdx;
    private int storeIdx;
    private  String id;
    private String img;
    private String content;
    private Double ratng;
}
