package com.therivex1907.StructYourLife.responses;

import lombok.Data;

@Data
public class OrderItemResponse {
    private Integer orderItemId;
    private Integer orderId;
    private Integer productId;
    private Integer quantity;
    private Double price;
}
