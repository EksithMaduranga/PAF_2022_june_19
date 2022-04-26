package com.example.electricitybill.repository;

import com.example.electricitybill.model.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepo extends CrudRepository<Payment, Integer> {
}
