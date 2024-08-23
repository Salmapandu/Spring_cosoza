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
@RequestMapping("api/v1/staffs")

public class StaffController {
    @Autowired
    public StaffService staffService;

    @PostMapping("add/staff")
    public ResponseEntity<?> createStaff(@RequestBody Staff staff) {
        try {
            Staff staff1 = staffService.save(staff);
            return new ResponseEntity<>("staff added successfully", HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(" failed to add staff", HttpStatus.BAD_REQUEST);
        }


    }
    @GetMapping("get/staffs")

    public ResponseEntity<?> getStaff(){
        try {
            List<Staff> StaffList = staffService.findAll();
            if (StaffList.isEmpty()){
                return new ResponseEntity<>("staff not found", HttpStatus.OK);

            }
            else {
                return new ResponseEntity<>(StaffList,HttpStatus.OK);
            }
        }catch (Exception e){
            return new ResponseEntity<>("Failed to retrieve staff",HttpStatus.BAD_REQUEST);

        }
    }

    @PutMapping("update/{staff_id}")
    public ResponseEntity<?> updateStaff(@PathVariable int staff_id, @RequestBody Staff staff){
        try {
            Optional<Staff> existingStaff = staffService.findById(staff_id);
            if (existingStaff.isPresent()){
                Staff staff1 = staffService.save(staff);
                return new ResponseEntity<>("staff was updated successfully", HttpStatus.OK);
            }else {
                return new ResponseEntity<>("staff not found", HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(" failed to update staff",HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete/{staff_id}")
    public ResponseEntity<?> deleteStaff(@PathVariable int staff_id ) {
        try {
            staffService.deleteById(staff_id);
            return new ResponseEntity<>("staff was deleted successfully", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("failed to delete staff",HttpStatus.BAD_REQUEST);

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
                return new ResponseEntity<>("staff not found ",HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>("Failed to retrieve staff ",HttpStatus.BAD_REQUEST);
        }

    }
}
