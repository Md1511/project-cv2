package com.alandha.order.mapper;

import com.alandha.order.order.Order;
import com.alandha.order.requestAndresponse.OrderRequest;
import com.alandha.order.requestAndresponse.OrderResponse;
import org.springframework.stereotype.Service;


@Service
public class OrderMapper {
    public Order toOrder(OrderRequest request) {
        return Order.builder()
                .id(request.id())
                .customerId(request.customerId())
                .reference(request.reference())
                .totalAmount(request.amount())
                .paymentMthod(request.paymentMethod())
                .build();
    }

    public OrderResponse formOrder(Order order) {
        return new OrderResponse(
                order.getId(),
                order.getReference(),
                order.getTotalAmount(),
                order.getPaymentMthod(),
                order.getCustomerId()
        );
    }
}
