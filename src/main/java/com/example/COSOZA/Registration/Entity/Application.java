package com.example.COSOZA.Registration.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Entity
@Table(name = "application")
@AllArgsConstructor
@NoArgsConstructor

public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int application_id;
    private String date;
    private String type;


    @ManyToOne
    @JoinColumn(name = "artist_id")
    private  Artist artist;

    @ManyToOne
    @JoinColumn(name = "licensee_id")
    private  Licensee licensee;






}


