package com.dailycodebuffer.PaymentService.service;

import com.dailycodebuffer.PaymentService.Model.PaymentRequest;
import org.springframework.http.HttpStatus;

public interface PaymentsService {
    long doPayment(PaymentRequest paymentRequest);
}
