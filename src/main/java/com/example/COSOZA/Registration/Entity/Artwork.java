package com.example.COSOZA.Registration.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "artwork")
@AllArgsConstructor
@NoArgsConstructor
public class Artwork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int artwork_id;
    private String artworktitle;
    private String artworktype;
    private String typeofright;
    private String rightholdername;
    private String dob;
    private String workmode;




    @ManyToOne
    @JoinColumn(name = "artist_id")
    private  Artist artist;




}
