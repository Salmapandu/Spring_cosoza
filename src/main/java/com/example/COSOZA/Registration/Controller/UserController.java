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
            return new ResponseEntity<>("user was posted", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("user was not posted",HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("get/users")
    public ResponseEntity<?> getStaff(){
        try {
            List<User> UserList = userService.findAll();
            if (UserList.isEmpty()){
                return new ResponseEntity<>("user not added",HttpStatus.BAD_REQUEST);
            }
            else {
                return new ResponseEntity<>(UserList,HttpStatus.ACCEPTED);
            }

        }catch (Exception e){
            return new ResponseEntity<>("user added successful",HttpStatus.OK);
        }
    }

    @PutMapping("update/{user_id}")
    public ResponseEntity<?> updateUser(@PathVariable int user_id, @RequestBody User user){
        try {
            if (userService.findById(user_id).isPresent()){
                User user1 = userService.save(user);
                return new ResponseEntity<>("user updated", HttpStatus.OK);
            }else {
                return new ResponseEntity<>("user not update",HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            return new ResponseEntity<>("user updated required",HttpStatus.BAD_GATEWAY);
        }
    }
    @DeleteMapping("/delete/{user_id}")
    public ResponseEntity<?> deleteUser(@PathVariable int user_id) {
        try {
            userService.deleteById(user_id);
            return new ResponseEntity<>("user was deleted",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("user was not delete",HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("getById/{user_id}")
    public ResponseEntity<?> getUserById(@PathVariable int user_id){
        try {
            Optional<User> optionalUser = userService.findById(user_id);
            if (optionalUser.isPresent()){
                return new ResponseEntity<>(optionalUser,HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>("user was accessed successful",HttpStatus.OK);

            }

        }catch (Exception e){
            return new ResponseEntity<>("user was not accessed",HttpStatus.BAD_REQUEST);
        }
    }
}
