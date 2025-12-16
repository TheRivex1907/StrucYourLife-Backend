package com.therivex1907.StructYourLife.requests;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {
    private Integer userId;
    private Integer state;
    private List<OrderItemRequest> orderItems;
}
