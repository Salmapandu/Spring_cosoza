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
@RequestMapping("api/v1/licensee")

public class LicenseeController {
    @Autowired
    public LicenseeService licenseeService;

    @PostMapping("add/licensee")
    public ResponseEntity<?> createLicensee(@RequestBody Licensee licensee){
        try {
            Licensee licensee1 = licenseeService.save(licensee);
            return new ResponseEntity<>("licensee added successfully", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("failed to add licensee",HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("get/licensees")
    public ResponseEntity<?> getLicensee(){
        try {
            List<Licensee> LicenseeList = licenseeService.findAll();
            if (LicenseeList.isEmpty()){
                return new ResponseEntity<>("no found licensee", HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(LicenseeList,HttpStatus.OK);
            }
        }catch (Exception e){
            return new ResponseEntity<>(" failed to retrieve licensee",HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("update/{licensee_id}")
    public ResponseEntity<?> updateLicensee(@PathVariable int licensee_id, @RequestBody Licensee licensee){
        try {
            Optional<Licensee> existingLicensee = licenseeService.findById(licensee_id);
            if (existingLicensee.isPresent()) {
                licenseeService.save(licensee);
                return new ResponseEntity<>("licensee updated successfully",HttpStatus.OK);
            }else {
                return new ResponseEntity<>("licensee not found",HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(" failed to update licensee",HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete/{licensee_id}")
    public ResponseEntity<?> deleteLicensee(@PathVariable int licensee_id){
        try {
            licenseeService.deleteById(licensee_id);
            return new ResponseEntity<>("licensee was deleted successfully",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(" failed to delete licensee",HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("getById/{licensee_id}")
    public ResponseEntity<?> getLicenseeById(@PathVariable int licensee_id){
        try {
            Optional<Licensee> optionalLicensee = licenseeService.findById(licensee_id);
            if (optionalLicensee.isPresent()){
                return new ResponseEntity<>(optionalLicensee.get(),HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>("licensee not found",HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(" failed to retrieve licensee",HttpStatus.BAD_REQUEST);
        }
    }
}
