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
    private ArtistRepository artistRepository;

    public Artist save(Artist artist) {
        return artistRepository.save(artist);
    }

    public List<Artist> findAll() {
        return artistRepository.findAll();
    }

    public Optional<Artist> findById(int id) {
        return artistRepository.findById(id);
    }

    public void deleteById(int id) {
        artistRepository.deleteById(id);
    }
}
