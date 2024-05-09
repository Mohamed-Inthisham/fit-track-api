package com.example.fitnesstest.controller;


import com.example.fitnesstest.DTO.LoginDTO;
import com.example.fitnesstest.DTO.UserDTO;
import com.example.fitnesstest.entity.User;
import com.example.fitnesstest.response.CommonResponse;
import com.example.fitnesstest.response.UserResponse;
import com.example.fitnesstest.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@Controller
@AllArgsConstructor
//@CrossOrigin(allowedHeaders = "http://localhost:3000")
public class UserController {

    private UserService userService;

    @PostMapping("/users/register")
    public ResponseEntity<Object> createUser(@RequestBody UserDTO userDTO) throws IOException {

        userService.saveUser(userDTO);
        return new ResponseEntity<>("User Registered!", HttpStatus.CREATED);
    }



    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> userList = userService.getAllUsers();

        return ResponseEntity.ok(userList);
    }

    @GetMapping("/users/{user_id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable("user_id") Long id) {
        UserResponse userResponse = userService.getUserById(id);
        return ResponseEntity.ok(userResponse);
    }

    @PutMapping("/users/{user_id}")
    public ResponseEntity<Object> updateUser(@RequestBody UserDTO userDTO, @PathVariable("user_id") Long id) throws IOException {

        return new ResponseEntity<>(userService.updateUser(userDTO, id), HttpStatus.CREATED);
    }


    @DeleteMapping("/users/{user_id}")
    public ResponseEntity<?> deleteUser(@PathVariable("user_id") Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User Deleted!");
    }

    @PostMapping("/users/login")
    public ResponseEntity<Object> loginUser(@RequestBody LoginDTO loginDTO) {
        return userService.loginUser(loginDTO);
    }
}
