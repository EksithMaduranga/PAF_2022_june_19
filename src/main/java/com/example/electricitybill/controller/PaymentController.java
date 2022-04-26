package com.example.electricitybill.controller;


import com.example.electricitybill.model.MeterTable;
import com.example.electricitybill.model.Payment;
import com.example.electricitybill.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/payment")
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @PostMapping("/add")
    public Payment save(@RequestBody Payment payment) {
        paymentService.saveOrUpdatePayment(payment);
        return payment;
    }

    @GetMapping("/listPayments")
    public List<Payment> list() {
        return paymentService.getAllPayments();
    }

    @GetMapping("/listPayments/{meterId}")
    public Payment getById(@PathVariable Integer meterId) {
        return paymentService.getById(meterId);
    }

    @DeleteMapping("/deletePayment/{meterId}")
    public String deletePayment(@PathVariable (value = "meterId") Integer meterId) {
        paymentService.deletePaymentById(meterId);
        return "Successfully Deleted Meter ID ="+meterId;
    }
}
