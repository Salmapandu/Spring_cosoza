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
@RequestMapping("api/v1/artwork")



public class ArtworkController {
    @Autowired
    public ArtworkService artworkService;

    @PostMapping("add/artwork")
    public ResponseEntity<?> createArtwork(@RequestBody Artwork artwork) {
        try {
            Artwork artwork1 = artworkService.save(artwork);
            return new ResponseEntity<>("artwork added successfully", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("failed to add artwork",HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("get/artwork")
    public ResponseEntity<?> getArtwork(){
        try {
            List<Artwork> ArtworkList = artworkService.findAll();
            if (ArtworkList.isEmpty()){
                return new ResponseEntity<>("no artwork found ",HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(ArtworkList,HttpStatus.OK);
            }
        }catch (Exception e){
            return new ResponseEntity<>("failed to retrieve artwork",HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("update/{artwork_id}")
    public ResponseEntity<?> updateArtwork(@PathVariable int artwork_id,@RequestBody Artwork artwork){
        try {
            Optional<Artwork> existingArtwork = artworkService.findById(artwork_id);
            if (existingArtwork.isPresent()) {
                artworkService.save(artwork);
                return new ResponseEntity<>("artwork updated successfully",HttpStatus.OK);
            }else {
                return new ResponseEntity<>("artwork not found",HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>("failed to update artwork",HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete/{artwork_id}")
    public ResponseEntity<?> deleteArtwork(@PathVariable int artwork_id){
        try {
            artworkService.deleteById(artwork_id);
            return new ResponseEntity<>("artwork was deleted successfully",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("failed to delete artwork",HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("getById/{artwork_id}")
    public ResponseEntity<?> getArtworkById(@PathVariable int artwork_id){
        try {
            Optional<Artwork> optionalArtwork = artworkService.findById(artwork_id);
            if (optionalArtwork.isPresent()){
                return new ResponseEntity<>(optionalArtwork.get(), HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>("artwork not found",HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>("failed to retrieve artwork",HttpStatus.BAD_REQUEST);
        }
    }
}
