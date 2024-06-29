package com.example.COSOZA.Registration.Controller;

import com.example.COSOZA.Registration.Entity.Licensee;
import com.example.COSOZA.Registration.Services.LicenseeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("api/licensee")

public class LicenseeController {
    @Autowired
    public LicenseeService licenseeService;

    @PostMapping("add/licensee")
    public ResponseEntity<?> createLicensee(@RequestBody Licensee licensee){
        try {
            Licensee licensee1 = licenseeService.save(licensee);
            return new ResponseEntity<>("licensee was posted", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("licensee was not posted",HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("get/licensees")
    public ResponseEntity<?> getLicensee(){
        try {
            List<Licensee> LicenseeList = licenseeService.findAll();
            if (LicenseeList.isEmpty()){
                return new ResponseEntity<>("licensee was not added", HttpStatus.BAD_REQUEST);
            }
            else {
                return new ResponseEntity<>(LicenseeList,HttpStatus.ACCEPTED);
            }
        }catch (Exception e){
            return new ResponseEntity<>("licensee added successful",HttpStatus.OK);
        }
    }

    @PutMapping("update/{licensee_id}")
    public ResponseEntity<?> updateLicensee(@PathVariable int licensee_id, @RequestBody Licensee licensee){
        try {
            if (licenseeService.findById(licensee_id).isPresent()){
                Licensee licensee1 = licenseeService.save(licensee);
                return new ResponseEntity<>("licensee updated",HttpStatus.OK);
            }else {
                return new ResponseEntity<>("licensee not updated",HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            return new ResponseEntity<>("licensee required updated",HttpStatus.BAD_GATEWAY);
        }
    }
    @DeleteMapping("/delete/{licensee_id}")
    public ResponseEntity<?> deleteLicensee(@PathVariable int licensee_id){
        try {
            licenseeService.deleteById(licensee_id);
            return new ResponseEntity<>("licensee was deleted",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("licensee was not deleted",HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("getById/{licensee_id}")
    public ResponseEntity<?> getLicenseeById(@PathVariable int licensee_id){
        try {
            Optional<Licensee> optionalLicensee = licenseeService.findById(licensee_id);
            if (optionalLicensee.isPresent()){
                return new ResponseEntity<>(optionalLicensee,HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>("licensee was accessed successful",HttpStatus.OK);
            }
        }catch (Exception e){
            return new ResponseEntity<>("licensee was not accessed",HttpStatus.BAD_REQUEST);
        }
    }
}
