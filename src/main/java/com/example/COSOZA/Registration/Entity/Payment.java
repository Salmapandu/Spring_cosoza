package com.example.COSOZA.Registration.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Entity
@Table(name = "payment")
@AllArgsConstructor
@NoArgsConstructor

public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int payment_id;
    private String amount_paid;
    private String date_paid;



    @OneToOne
    @JoinColumn(name = "application_id")
    private Application application;



}
