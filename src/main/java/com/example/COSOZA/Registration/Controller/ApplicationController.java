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
@RequestMapping("api/v1/application")

public class ApplicationController {

    @Autowired
    public ApplicationService applicationService;

    @PostMapping("add/application")
    public ResponseEntity<?> createApplication(@RequestBody Application application) {
        try {
            Application application1 = applicationService.save(application);
            return new ResponseEntity<>("application was added successfully", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("application was failed",HttpStatus.BAD_REQUEST);
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
            Optional<Application> existingApplication = applicationService.findById(application_id);
            if (existingApplication.isPresent()){
                applicationService.save(application);
                return new ResponseEntity<>("application updated successfully",HttpStatus.OK);
            }else {
                return new ResponseEntity<>("application was not found",HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>("failed  to updated application",HttpStatus.BAD_REQUEST);
        }
    }
   @DeleteMapping("/delete/{application_id}")
   public ResponseEntity<?> deleteApplicationById(@PathVariable int application_id) {
        try {
            applicationService.deleteById(application_id);
            return new ResponseEntity<>("application deleted successfully ",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("failed to deleted application",HttpStatus.BAD_REQUEST);
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
                return new ResponseEntity<>("application was not found ",HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>("failed to retrieve application",HttpStatus.BAD_REQUEST);
        }
   }
}
