package com.example.COSOZA.Registration.Controller;

import com.example.COSOZA.Registration.Entity.Application;
import com.example.COSOZA.Registration.Services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("api/application")

public class ApplicationController {

    @Autowired
    public ApplicationService applicationService;

    @PostMapping("add/application")
    public ResponseEntity<?> createApplication(@RequestBody Application application) {
        try {
            Application application1 = applicationService.save(application);
            return new ResponseEntity<>("application was posted", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("application was not posted",HttpStatus.BAD_REQUEST);
        }
    }
        @GetMapping("get/applications")
    public ResponseEntity<?> getApplication(){
        try {
            List<Application> ApplicationList = applicationService.findAll();
            if (ApplicationList.isEmpty()){
                return new ResponseEntity<>("application not added",HttpStatus.BAD_REQUEST);

            }
            else {
                return new ResponseEntity<>(ApplicationList,HttpStatus.ACCEPTED);
            }
        }catch (Exception e){
            return new ResponseEntity<>("application added successful",HttpStatus.OK);
        }

    }
    @PutMapping("update/{application_id}")
    public ResponseEntity<?> updateApplication(@PathVariable int application_id, @RequestBody Application application){
        try {
            if (applicationService.findById(application_id).isPresent()){
                Application application1 = applicationService.save(application);
                return new ResponseEntity<>("appication updated",HttpStatus.OK);
            }else {
                return new ResponseEntity<>("application was not updated",HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            return new ResponseEntity<>("application required updated",HttpStatus.BAD_GATEWAY);
        }
    }
   @DeleteMapping("/delete/{application_id}")
   public ResponseEntity<?> deleteApplication(@PathVariable int application_id) {
        try {
            applicationService.deleteById(application_id);
            return new ResponseEntity<>("application was deleted",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("application was not deleted",HttpStatus.BAD_REQUEST);
        }
   }

   @GetMapping("getById/{application_id}")
    public ResponseEntity<?> getStaffById(@PathVariable int application_id){
        try {
            Optional<Application> optionalApplication = applicationService.findById(application_id);
            if (optionalApplication.isPresent()){
                return new ResponseEntity<>(optionalApplication,HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>("application was accessed successful",HttpStatus.OK);
            }
        }catch (Exception e){
            return new ResponseEntity<>("application was not accessed",HttpStatus.BAD_REQUEST);
        }
   }
}
