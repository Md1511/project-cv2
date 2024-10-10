package com.alandha.notification.repository;

import com.alandha.notification.notification.Notification;
import com.alandha.notification.record.PaymentConfirmation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepository extends MongoRepository<Notification, String> {
}
