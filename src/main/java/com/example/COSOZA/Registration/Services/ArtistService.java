package com.example.COSOZA.Registration.Services;

import com.example.COSOZA.Registration.Entity.Artist;
import com.example.COSOZA.Registration.Repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistService {


    @Autowired
    private PasswordService passwordService;


    @Autowired
    private ArtistRepository artistRepository;



    public List<Artist> findAll() {
        return artistRepository.findAll();
    }

    public Artist save(Artist artist) {
//        //check if the Artist member already exists based on a unique identifier
        Optional<Artist> existingArtist = artistRepository.findByEmail(artist.getEmail());

        if (existingArtist.isPresent()) {
            throw new RuntimeException();
        }


        // Encode the password before saving
        if (artist.getPassword() != null && !artist.getPassword().isEmpty()) {
            artist.setPassword(passwordService.encodePassword(artist.getPassword()));
        }
        return artistRepository.save(artist);
    }




    public Optional<Artist> findById(int id) {
        return artistRepository.findById(id);
    }

    public void deleteById(int id) {
        artistRepository.deleteById(id);
    }
}
