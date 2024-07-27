package com.example.COSOZA.Registration.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "artist")

public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int artist_id;
    private String firstname;
    private String lastname;
    private String email;
    private String date;
    private String gender;
    private String worktype;
    private String worktitle;
    private String reg_no;
    private String address;


}
