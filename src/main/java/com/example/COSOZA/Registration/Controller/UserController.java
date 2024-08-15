package com.example.COSOZA.Registration.Controller;

import com.example.COSOZA.Registration.Entity.User;
import com.example.COSOZA.Registration.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("api/user")

public class UserController {
    @Autowired
    public UserService userService;

    @PostMapping("add/user")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        try {
            User user1 = userService.save(user);
            return new ResponseEntity<>("user added successfully", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("failed to add user",HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("get/users")
    public ResponseEntity<?> getStaff(){
        try {
            List<User> UserList = userService.findAll();
            if (UserList.isEmpty()){
                return new ResponseEntity<>("no user found",HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(UserList,HttpStatus.OK);
            }

        }catch (Exception e){
            return new ResponseEntity<>("failed to retrieve user",HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("update/{user_id}")
    public ResponseEntity<?> updateUser(@PathVariable int user_id, @RequestBody User user){
        try {
            Optional<User> existingUser = userService.findById(user_id);
            if (existingUser.isPresent()){
                User user1 = userService.save(user);
                return new ResponseEntity<>("user updated successfully", HttpStatus.OK);
            }else {
                return new ResponseEntity<>("user not found",HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>("failed to update user",HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete/{user_id}")
    public ResponseEntity<?> deleteUser(@PathVariable int user_id) {
        try {
            userService.deleteById(user_id);
            return new ResponseEntity<>("user was deleted successfully",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("failed to delete user",HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("getById/{user_id}")
    public ResponseEntity<?> getUserById(@PathVariable int user_id){
        try {
            Optional<User> optionalUser = userService.findById(user_id);
            if (optionalUser.isPresent()){
                return new ResponseEntity<>(optionalUser.get(),HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>("user not found",HttpStatus.NOT_FOUND);

            }

        }catch (Exception e){
            return new ResponseEntity<>("failed to retrieve user",HttpStatus.BAD_REQUEST);
        }
    }
}
