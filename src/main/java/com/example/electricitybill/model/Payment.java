package com.example.electricitybill.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@Entity
@Data
public class Payment {
    @Id
    @Column(name = "meterId")
    private Integer meterId;

    private String date;

    private String userId;

    @Column(name = "noOfUnits")
    private Integer noOfUnits;

    private Double paymentAmount;

    private String paymentStatus = "Paid";
}
