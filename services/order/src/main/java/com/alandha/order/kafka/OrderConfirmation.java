package com.alandha.order.kafka;

import com.alandha.order.PaymentMethod;
import com.alandha.order.requestAndresponse.CustomerResponse;
import com.alandha.order.requestAndresponse.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customerResponse,
        List<PurchaseResponse> products
) {

}
