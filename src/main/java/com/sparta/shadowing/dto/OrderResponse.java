package com.sparta.shadowing.dto;

import com.sparta.shadowing.entity.Order;
import lombok.Getter;

@Getter
public class OrderResponse {

    private final Long orderId;

    public OrderResponse(Order order) {
        this.orderId = order.getId();
    }
}
