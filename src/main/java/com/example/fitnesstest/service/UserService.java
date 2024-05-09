package com.example.fitnesstest.service;

import com.example.fitnesstest.DTO.LoginDTO;
import com.example.fitnesstest.DTO.UserDTO;
import com.example.fitnesstest.entity.User;
import com.example.fitnesstest.response.CommonResponse;
import com.example.fitnesstest.response.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public interface UserService {
    ResponseEntity<Object> saveUser(UserDTO userDTO) throws IOException;

    List<User> getAllUsers();

    UserResponse getUserById(Long id);

    void deleteUser(Long id);

    ResponseEntity<Object> updateUser(UserDTO userDTO, Long id) throws IOException;


    ResponseEntity<CommonResponse> registerUser(UserDTO userDTO);

    ResponseEntity<Object> loginUser(LoginDTO loginDTO);
}
