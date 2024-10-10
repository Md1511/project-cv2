package com.alandha.payment.service;

import com.alandha.payment.mapper.PaymentMapper;
import com.alandha.payment.notification.NotificationProducer;
import com.alandha.payment.repository.PaymentRepository;
import com.alandha.payment.notification.PaymentNotificationRequest;
import com.alandha.payment.requestAndresponse.PaymentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository repo;
    private final PaymentMapper mapper;
    private final NotificationProducer notificationProducer;

    @Override
    public Integer createPayment(PaymentRequest request) {
        var payment = repo.save(mapper.toPayment(request));

        notificationProducer.sendNotification(
                new PaymentNotificationRequest(
                        request.orderReference(),
                        request.amount(),
                        request.paymentMethod(),
                        request.customer().firstName(),
                        request.customer().lastName(),
                        request.customer().email()
                )
        );

        return payment.getId();
    }
}
