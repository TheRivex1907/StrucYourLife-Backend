package com.therivex1907.StructYourLife.reponses;

import lombok.Data;

@Data
public class ProductResponse {
    private Integer productId;
    private Integer categoryId;
    private Integer userId;
    private String name;
    private Integer stock;
    private Integer price;
}
