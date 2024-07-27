package com.example.COSOZA.Registration.Controller;

import com.example.COSOZA.Registration.Entity.Artist;
import com.example.COSOZA.Registration.Services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("api/artist")
public class ArtistController {

    @Autowired
    public ArtistService artistService;

    @PostMapping("add/artist")
    public ResponseEntity<?> createArtist(@RequestBody Artist artist) {
        try {
            Artist artist1 = artistService.save(artist);
            return new ResponseEntity<>("Artist was posted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Artist was not posted: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("get/artists")
    public ResponseEntity<?> getArtist() {
        try {
            List<Artist> ArtistList = artistService.findAll();
            if (ArtistList.isEmpty()) {
                return new ResponseEntity<>("No artists found", HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(ArtistList, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to retrieve artists: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("update/{artist_id}")
    public ResponseEntity<?> updateArtist(@PathVariable int artist_id, @RequestBody Artist artist) {
        try {
            if (artistService.findById(artist_id).isPresent()) {
                artistService.save(artist);
                return new ResponseEntity<>("Artist updated", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Artist not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to update artist: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{artist_id}")
    public ResponseEntity<?> deleteArtist(@PathVariable int artist_id) {
        try {
            artistService.deleteById(artist_id);
            return new ResponseEntity<>("Artist was deleted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to delete artist: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("getById/{artist_id}")
    public ResponseEntity<?> getArtistById(@PathVariable int artist_id) {
        try {
            Optional<Artist> optionalArtist = artistService.findById(artist_id);
            if (optionalArtist.isPresent()) {
                return new ResponseEntity<>(optionalArtist, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Artist not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to retrieve artist: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
