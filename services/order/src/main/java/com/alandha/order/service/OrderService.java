package com.alandha.order.service;

import com.alandha.order.requestAndresponse.OrderRequest;
import com.alandha.order.requestAndresponse.OrderResponse;

import java.util.List;

public interface OrderService {
    Integer createdOrder(OrderRequest request);

    List<OrderResponse> findAll();

    OrderResponse findById(Integer orderId);
}
