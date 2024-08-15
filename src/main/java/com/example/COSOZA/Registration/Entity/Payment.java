package com.example.COSOZA.Registration.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;


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
    private String control_number;

    @PrePersist
    public void generatecontrolnumber(){
        if (control_number == null){
            String datePart = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
            String randomPart = String.format("%03d", new Random().nextInt(1000));
            control_number = "SALMA-" +datePart + randomPart;
        }

    }




    @OneToOne
    @JoinColumn(name = "application_id")
    private Application application;



}
