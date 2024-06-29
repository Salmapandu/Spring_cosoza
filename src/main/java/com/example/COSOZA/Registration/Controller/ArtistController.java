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


        }catch (Exception e){
            return new ResponseEntity<>("artist was not posted",HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("get/artists")

    public ResponseEntity<?> getArtist(){
        try {
            List<Artist> ArtistList = artistService.findAll();
            if (ArtistList.isEmpty()){
                return new ResponseEntity<>("Artist was not added",HttpStatus.BAD_REQUEST);
            }
            else {
                return new ResponseEntity<>(ArtistList,HttpStatus.ACCEPTED);
            }
        }catch (Exception e){
            return new ResponseEntity<>("artist added successful",HttpStatus.OK);
        }
    }
    @PutMapping("update/{artist_id}")
    public ResponseEntity<?> updateArtist(@PathVariable int artist_id, @RequestBody Artist artist){
        try {
            if (artistService.findById(artist_id).isPresent()){
                Artist artist1 =artistService.save(artist);
                return new ResponseEntity<>("artist updated",HttpStatus.OK);
            }else {
                return new ResponseEntity<>("artist not updated",HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            return new ResponseEntity<>("artist updated required",HttpStatus.BAD_GATEWAY);
        }
    }

    @DeleteMapping("/delete/{artist_id}")
    public ResponseEntity<?> deleteArtist(@PathVariable int artist_id){
        try {
            artistService.deleteById(artist_id);
            return new ResponseEntity<>("artist was deleted",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("artist was not deleted",HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("getById/{artist_id}")
    public ResponseEntity<?> getArtistById(@PathVariable int artist_id){
        try {
            Optional<Artist> optionalArtist =artistService.findById(artist_id);
            if (optionalArtist.isPresent()){
                return new ResponseEntity<>(optionalArtist,HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>("artist was accessed successful",HttpStatus.OK);
            }
        }catch (Exception e){
            return new ResponseEntity<>("artist was not accessed",HttpStatus.BAD_REQUEST);
        }
    }
}
