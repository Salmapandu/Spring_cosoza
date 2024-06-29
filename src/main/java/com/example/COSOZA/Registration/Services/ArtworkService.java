package com.example.COSOZA.Registration.Services;

import com.example.COSOZA.Registration.Entity.Artwork;
import com.example.COSOZA.Registration.Repository.ArtworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ArtworkService {

    @Autowired

    private ArtworkRepository artworkRepository;

    public Artwork saveArtwork(Artwork artwork){
        return artworkRepository.save(artwork);

    }

    public List<Artwork> findAll() {
        return artworkRepository.findAll();
    }

    public Artwork save(Artwork artwork) {
        return artworkRepository.save(artwork);
    }

    public void deleteById(int artwork_id) {
        artworkRepository.deleteById( artwork_id);
    }
    public Optional<Artwork> findById(int  artwork_id) {
        return artworkRepository.findById( artwork_id);
    }

}
