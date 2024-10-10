package com.alandha.order.service;

import com.alandha.order.requestAndresponse.OrderLineResponse;
import com.alandha.order.requestAndresponse.OrderLineRequest;

import java.util.List;

public interface OrderLineService  {
    Integer saveOrderLine(OrderLineRequest orderLineRequest);

    List<OrderLineResponse> findAllByOrderId(Integer orderId);
}
