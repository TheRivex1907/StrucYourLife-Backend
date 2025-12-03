package com.therivex1907.StructYourLife.services;

import com.therivex1907.StructYourLife.responses.BaseResponse;
import com.therivex1907.StructYourLife.responses.OrderItemResponse;
import com.therivex1907.StructYourLife.responses.OrderResponse;
import com.therivex1907.StructYourLife.repositories.NativeQueryRepository;
import com.therivex1907.StructYourLife.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private NativeQueryRepository nativeQueryRepository;

    public BaseResponse<?> listOrdersByParameters(Integer categoryId, Integer userId, Integer state) {
        List<Object[]> data = nativeQueryRepository.listOrdersByParameters(categoryId, userId, state);
        if (data.isEmpty()) {
            return new BaseResponse<>(404, "Data Not Found", null);
        }
        List<OrderResponse> orders = new ArrayList<>();
        HashMap<Integer, OrderResponse> orderMap = new HashMap<>();

        for (Object[] obj : data) {
            Integer orderId = (Integer) obj[0];
            OrderResponse order = orderMap.get(orderId);

            if (order == null) {
                order = new OrderResponse();
                order.setOrderId(orderId);
                order.setUserId((Integer) obj[1]);
                order.setCreatedAt((LocalDateTime) obj[2]);
                order.setState((Integer) obj[3]);
                order.setOrderItems(new ArrayList<>());
                orders.add(order);
                orderMap.put(orderId, order);
            }

            OrderItemResponse orderItem = new OrderItemResponse();
            orderItem.setOrderItemId((Integer) obj[4]);
            orderItem.setOrderId(orderId);
            orderItem.setProductId((Integer) obj[5]);
            orderItem.setQuantity((Integer) obj[6]);
            orderItem.setPrice((Double) obj[7]);

            order.getOrderItems().add(orderItem);
        }
        return new BaseResponse<>(200, "Ok",  orders);
    }
}
