package com.example.deliver.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "review")
public class Review {
    @Id
    private  int reviewIdx;
    private  String id;
    private String img;
    private String content;
    private Double ratng;
}
