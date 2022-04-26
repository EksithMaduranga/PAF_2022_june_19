package com.example.electricitybill.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@Entity
@Data
@Table(name = "meterTable")
public class MeterTable {
    @Id
    @Column(name = "meterId")
    private Integer meterId;

    private String userId;

    private String meterAddress;

    private String date;

    @Column(name = "noOfUnits")
    private double noOfUnits;

    private String paymentStatus = "Not Paid";

    public double getPayment() {
        double payment = 0;
        if (noOfUnits < 100) {
            payment = noOfUnits * 1.20;
        }
        else if (noOfUnits <= 300) {
            payment = 100 * 1.20 + (noOfUnits-100)*2;
        }
        else if (noOfUnits > 300) {
            payment = 100*1.20 + 200*2 + (noOfUnits-300)*3;
        }
        return payment;
    }
}
