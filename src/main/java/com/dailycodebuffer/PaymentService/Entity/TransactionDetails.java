package com.dailycodebuffer.PaymentService.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table
public class TransactionDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "ORDER_ID")
    private long orderId;
    @Column(name = "PAYMENT_MODE")
    private  String paymentMode;
    @Column(name = "REFERENCE_NUMBER")
    private  String referenceNumber;
    @Column(name = "PAYMENT_DATE")
    private Instant paymentDate;
    @Column(name = "PAYMENT_STATUS")
    private String paymentStatus;
    @Column(name = "TOTAL_AMOUNT")
    private long amount;
}
