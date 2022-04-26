package com.example.electricitybill.service;


import com.example.electricitybill.model.Payment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PaymentService {
    List<Payment> getAllPayments();

    Payment getById(Integer meterId);

    void saveOrUpdatePayment(Payment payment);

    void deletePaymentById(Integer meterId);
}
