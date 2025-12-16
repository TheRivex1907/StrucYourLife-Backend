package com.therivex1907.StructYourLife.services;

import com.therivex1907.StructYourLife.models.OrderItem;
import com.therivex1907.StructYourLife.requests.OrderItemRequest;
import com.therivex1907.StructYourLife.responses.BaseResponse;
import com.therivex1907.StructYourLife.responses.OrderItemResponse;
import com.therivex1907.StructYourLife.repositories.OrderItemRepository;
import com.therivex1907.StructYourLife.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdenItemService {
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private OrderRepository orderRepository;

    public BaseResponse<?> listItemsByOrderId(Integer orderId) {
        boolean exists = orderRepository.existsById(orderId);
        if (!exists) {
            return new  BaseResponse<>(404, "Order Not Found", null);
        }
        List<OrderItem> data = orderItemRepository.findByOrderIdAndIsActive(orderId, true);
        if (data.isEmpty()) {
            return new  BaseResponse<>(404, "No Data Found", null);
        }
        List<OrderItemResponse> orderItems = new ArrayList<>();
        for (OrderItem obj: data) {
            OrderItemResponse transformed = new OrderItemResponse();
            transformed.setOrderItemId(obj.getOrderItemId());
            transformed.setOrderId(obj.getOrderId());
            transformed.setProductId(obj.getProductId());
            transformed.setQuantity(obj.getQuantity());
            transformed.setPrice(obj.getPrice());
            orderItems.add(transformed);
        }
        return new  BaseResponse<>(200, "Ok", orderItems);
    }

    public BaseResponse<?> createOrderItem(OrderItemRequest orderItemRequest) {
        OrderItem newOrderItem = new OrderItem();
        newOrderItem.setOrderId(orderItemRequest.getOrderId());
        newOrderItem.setProductId(orderItemRequest.getProductId());
        newOrderItem.setQuantity(orderItemRequest.getQuantity());
        newOrderItem.setPrice(orderItemRequest.getPrice());

        return new BaseResponse<>(200, "OK", newOrderItem);
    }
}
