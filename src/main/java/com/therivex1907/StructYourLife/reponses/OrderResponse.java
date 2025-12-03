package com.therivex1907.StructYourLife.reponses;

import com.therivex1907.StructYourLife.models.OrderItem;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderResponse {
    private Integer orderId;
    private Integer userId;
    private LocalDateTime createdAt;
    private Integer state;
    private List<OrderItemResponse> orderItems;
}
