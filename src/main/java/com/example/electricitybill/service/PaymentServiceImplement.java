package com.example.electricitybill.service;

import com.example.electricitybill.model.Payment;
import com.example.electricitybill.repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PaymentServiceImplement implements PaymentService{

    @Autowired
    PaymentRepo paymentRepo;

    @Override
    public List<Payment> getAllPayments() {
        return (List<Payment>) paymentRepo.findAll();
    }

    @Override
    public Payment getById(Integer meterId) {
        return paymentRepo.findById(meterId).get();
    }

    @Override
    public void saveOrUpdatePayment(Payment payment) {
        paymentRepo.save(payment);
    }

    @Override
    public void deletePaymentById(Integer meterId) {
        paymentRepo.deleteById(meterId);
    }
}
