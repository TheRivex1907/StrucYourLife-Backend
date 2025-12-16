package com.therivex1907.StructYourLife.requests;

import lombok.Data;

@Data
public class OrderItemRequest {
    private Integer orderId;
    private Integer productId;
    private Integer quantity;
    private Double price;
}
