package com.dailycodebuffer.PaymentService.service;

import com.dailycodebuffer.PaymentService.Model.PaymentRequest;
import com.dailycodebuffer.PaymentService.Model.PaymentResponse;
import org.springframework.http.HttpStatus;

public interface PaymentsService {
    long doPayment(PaymentRequest paymentRequest);

    PaymentResponse getPaymentDetails(long id);
}
