package com.example.COSOZA.Registration.Controller;

import com.example.COSOZA.Registration.Entity.Artwork;
import com.example.COSOZA.Registration.Services.ArtworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("api/artwork")



public class ArtworkController {
    @Autowired
    public ArtworkService artworkService;

    @PostMapping("add/artwork")
    public ResponseEntity<?> createArtwork(@RequestBody Artwork artwork) {
        try {
            Artwork artwork1 = artworkService.save(artwork);
            return new ResponseEntity<>("artwork was posted", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("artwork was not posted",HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("get/arti")
    public ResponseEntity<?> getArtwork(){
        try {
            List<Artwork> ArtworkList = artworkService.findAll();
            if (ArtworkList.isEmpty()){
                return new ResponseEntity<>("artwork not added",HttpStatus.BAD_REQUEST);
            }
            else {
                return new ResponseEntity<>(ArtworkList,HttpStatus.ACCEPTED);
            }
        }catch (Exception e){
            return new ResponseEntity<>("artwork added successful",HttpStatus.OK);
        }
    }

    @PutMapping("update/{artwork_id}")
    public ResponseEntity<?> updateArtwork(@PathVariable int artwork_id,@RequestBody Artwork artwork){
        try {
            if (artworkService.findById(artwork_id).isPresent()){
                Artwork artwork1 = artworkService.save(artwork);
                return new ResponseEntity<>("artwork updated",HttpStatus.OK);
            }else {
                return new ResponseEntity<>("artwork not updated",HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            return new ResponseEntity<>("artwork updated required",HttpStatus.BAD_GATEWAY);
        }
    }
    @DeleteMapping("/delete/{artwork_id}")
    public ResponseEntity<?> deleteArtwork(@PathVariable int artwork_id){
        try {
            artworkService.deleteById(artwork_id);
            return new ResponseEntity<>("artwork was deleted",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("artwork was not deleted",HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("getById/{artwork_id}")
    public ResponseEntity<?> getArtworkById(@PathVariable int artwork_id){
        try {
            Optional<Artwork> optionalArtwork = artworkService.findById(artwork_id);
            if (optionalArtwork.isPresent()){
                return new ResponseEntity<>(optionalArtwork,HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>("artwork was accessed successful",HttpStatus.OK);
            }
        }catch (Exception e){
            return new ResponseEntity<>("artwork was not accessed",HttpStatus.BAD_REQUEST);
        }
    }
}
