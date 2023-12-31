package com.dailycodebuffer.PaymentService.service;

import com.dailycodebuffer.PaymentService.Entity.TransactionDetails;
import com.dailycodebuffer.PaymentService.Model.PaymentRequest;
import com.dailycodebuffer.PaymentService.Model.PaymentResponse;
import com.dailycodebuffer.PaymentService.repository.PaymentRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
public class PaymentsServiceImpl implements PaymentsService{

    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public long doPayment(PaymentRequest paymentRequest) {
        log.info("doing payment");
        TransactionDetails transactionDetails = TransactionDetails.builder()
                .amount(paymentRequest.getAmount())
                .orderId(paymentRequest.getOrderId())
                .paymentDate(Instant.now())
                .paymentMode(paymentRequest.getPaymentMode().name())
                .paymentStatus("SUCCESS")
                .referenceNumber(paymentRequest.getReferenceNumber())
                .build();
        paymentRepository.save(transactionDetails);
        log.info("Transaction details completed with id:{}",transactionDetails.getId());

        return transactionDetails.getId();
    }

    @Override
    public PaymentResponse getPaymentDetails(long id) {
        log.info("fetching transaction details for id:{}",id);
        TransactionDetails transactionDetails = paymentRepository.findById(id).orElseThrow(()-> new RuntimeException("Payment details not found for order id: "+id));
        return PaymentResponse.builder()
                .orderId(transactionDetails.getOrderId())
                .amount(transactionDetails.getAmount())
                .paymentMode(transactionDetails.getPaymentMode())
                .referenceNumber(transactionDetails.getReferenceNumber())
                .build();
    }
}
