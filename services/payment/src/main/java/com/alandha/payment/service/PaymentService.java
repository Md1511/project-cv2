package com.alandha.payment.service;

import com.alandha.payment.requestAndresponse.PaymentRequest;

public interface PaymentService {
    Integer createPayment(PaymentRequest request);
}
