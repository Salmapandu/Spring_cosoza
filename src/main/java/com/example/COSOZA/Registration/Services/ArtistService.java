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

    public Artist saveArtist(Artist artist){
        return artistRepository.save(artist);

    }

    public List<Artist> findAll() {
        return artistRepository.findAll();
    }

    public Artist save(Artist artist) {
        return artistRepository.save(artist);
    }

    public void deleteById(int artist_id) {
        artistRepository.deleteById(  artist_id);
    }
    public Optional<Artist> findById(int  artist_id) {
        return artistRepository.findById( artist_id);
    }

}
