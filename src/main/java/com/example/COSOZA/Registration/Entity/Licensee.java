package com.example.COSOZA.Registration.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "licensee")

public class Licensee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int licensee_id;
    private String address;
    private String mobile_phone;



}
