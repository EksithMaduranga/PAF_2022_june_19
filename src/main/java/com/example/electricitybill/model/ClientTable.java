package com.example.electricitybill.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ClientTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    private String userId;

    private String userName;
}
