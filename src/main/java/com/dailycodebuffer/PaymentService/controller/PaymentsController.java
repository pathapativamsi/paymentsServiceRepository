package com.dailycodebuffer.PaymentService.controller;

import com.dailycodebuffer.PaymentService.Model.PaymentRequest;
import com.dailycodebuffer.PaymentService.service.PaymentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentsController {

    @Autowired
    private PaymentsService paymentsService;

    @PostMapping
    public ResponseEntity<Long> doPayment(@RequestBody PaymentRequest paymentRequest){
        return new ResponseEntity<>(paymentsService.doPayment(paymentRequest), HttpStatus.CREATED);
    }
}
