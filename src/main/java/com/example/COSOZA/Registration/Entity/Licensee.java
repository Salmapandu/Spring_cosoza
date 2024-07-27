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
    private String firstname;
    private String lastname;
    private String email;
    private String date;
    private String gender;
    private String licensetype;
    private String deviceused;
    private String reg_no;
    private String address;





}
