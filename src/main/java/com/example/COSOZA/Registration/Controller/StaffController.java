package com.example.COSOZA.Registration.Controller;

import com.example.COSOZA.Registration.Entity.Staff;
import com.example.COSOZA.Registration.Services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("api/staffs")

public class StaffController {
    @Autowired
    public StaffService staffService;

    @PostMapping("add/staff")
    public ResponseEntity<?> createStaff(@RequestBody Staff staff) {
        try {
            Staff staff1 = staffService.save(staff);
            return new ResponseEntity<>("staff was posted", HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>("staff was not posted", HttpStatus.BAD_REQUEST);
        }


    }
    @GetMapping("get/staffs")

    public ResponseEntity<?> getStaff(){
        try {
            List<Staff> StaffList = staffService.findAll();
            if (StaffList.isEmpty()){
                return new ResponseEntity<>("staff not added", HttpStatus.BAD_REQUEST);

            }
            else {
                return new ResponseEntity<>(StaffList,HttpStatus.ACCEPTED);
            }
        }catch (Exception e){
            return new ResponseEntity<>("staff added successful",HttpStatus.OK);

        }
    }

    @PutMapping("update/{staff_id}")
    public ResponseEntity<?> updateStaff(@PathVariable int staff_id, @RequestBody Staff staff){
        try {
            if (staffService.findById(staff_id).isPresent()){
                Staff staff1 = staffService.save(staff);
                return new ResponseEntity<>("staff was updated", HttpStatus.OK);
            }else {
                return new ResponseEntity<>("staff was not updated", HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            return new ResponseEntity<>("staff updated required",HttpStatus.BAD_GATEWAY);
        }
    }
    @DeleteMapping("/delete/{staff_id}")
    public ResponseEntity<?> deleteStaff(@PathVariable int staff_id ) {
        try {
            staffService.deleteById(staff_id);
            return new ResponseEntity<>("staff was deleted", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("staff was not deleted",HttpStatus.BAD_REQUEST);

        }

    }
    @GetMapping("getById/{staff_id}")
    public ResponseEntity<?> getStaffById(@PathVariable int staff_id){
        try {
            Optional<Staff> optionalStaff = staffService.findById(staff_id);
            if (optionalStaff.isPresent()){
                return new ResponseEntity<>(optionalStaff,HttpStatus.OK );
            }
            else {
                return new ResponseEntity<>("staff was accessed successful",HttpStatus.OK);
            }
        }catch (Exception e){
            return new ResponseEntity<>("staff was not accessed",HttpStatus.BAD_REQUEST);
        }

    }
}
