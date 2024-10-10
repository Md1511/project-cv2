package com.alandha.order.requestAndresponse;

import com.alandha.order.PaymentMethod;

import java.math.BigDecimal;

public record OrderResponse (
        Integer id,
        String reference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String customerId
){
}
