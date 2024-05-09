package com.example.fitnesstest.service.impl;

import com.example.fitnesstest.DTO.LoginDTO;
import com.example.fitnesstest.DTO.UserDTO;
import com.example.fitnesstest.entity.User;
import com.example.fitnesstest.repository.UserRepository;
import com.example.fitnesstest.response.CommonResponse;
import com.example.fitnesstest.response.UserResponse;
import com.example.fitnesstest.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    public static String uploadDirecory = System.getProperty("user.dir") + "/src/main/images";

    @Override
    public ResponseEntity<Object> saveUser(UserDTO userDTO) throws IOException {
        if(userDTO.getSource() == null){

            User user = new User();
            user.setFirstName(userDTO.getFirstName());
            user.setLastName(userDTO.getLastName());
            user.setUsername(userDTO.getUsername());
            user.setPhoneNumber(userDTO.getPhoneNumber());
            user.setPasswordHash(passwordEncoder.encode(userDTO.getPassword()));
            user.setBio(userDTO.getBio());
            user.setEmail(userDTO.getEmail());
            user.setProfilePictureUrl(userDTO.getProfilePictureUrl());
            user.setSource(userDTO.getSource());
            userRepository.save(user);

            userRepository.save(user);
            UserResponse userResponse = UserResponse.builder()
                    .id(user.getUserId())
                    .username(user.getUsername())
                    .email(user.getEmail())
                    .profilePictureUrl(user.getProfilePictureUrl())
                    .bio(user.getBio())
                    .phoneNumber(user.getPhoneNumber())
                    .build();

            return  new ResponseEntity<>(userResponse,HttpStatus.OK);

        }

        if(Objects.equals(userDTO.getSource(), "google")){
            String email = userDTO.getEmail();
            System.out.println("user source = "+userDTO.getSource());
            Optional<User> userOptional = userRepository.findUserByEmail(email);
            if(userOptional.isPresent()){
                User user = userOptional.get();
                UserResponse userResponse = UserResponse.builder()
                        .id(user.getUserId())
                        .username(user.getUsername())
                        .email(user.getEmail())
                        .profilePictureUrl(user.getProfilePictureUrl())
                        .build();
               return new ResponseEntity<>(userResponse, HttpStatus.OK);

            }

            User googleUser = new User();
            googleUser.setUsername(userDTO.getUsername());
            googleUser.setEmail(userDTO.getEmail());
            googleUser.setProfilePictureUrl(userDTO.getProfilePictureUrl());
            try {
                userRepository.save(googleUser);
                UserResponse userResponse = UserResponse.builder()
                        .id(googleUser.getUserId())
                        .username(googleUser.getUsername())
                        .email(googleUser.getEmail())
                        .build();
                return new ResponseEntity<>(userResponse, HttpStatus.OK);
            }catch (DataIntegrityViolationException e){
                return new ResponseEntity<>("Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {

        List<User> userList = userRepository.findAll();
        List<User> userResponseList = new ArrayList<>();
        for (User user : userList) {
            User user1 = new User();
            user1.setUserId(user.getUserId());
            user1.setFirstName(user.getFirstName());
            user1.setLastName(user.getLastName());
            user1.setEmail(user.getEmail());
            user1.setPhoneNumber(user.getPhoneNumber());
            user1.setUsername(user.getUsername());
            user1.setProfilePictureUrl(user.getProfilePictureUrl());
//            user1.setPostList(user.getPostList());

            userResponseList.add(user1);
        }
        return userResponseList;
    }

    @Override
    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("User Not Found")
        );

        UserResponse userResponse = UserResponse.builder()
                .id(user.getUserId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .username(user.getUsername())
                .email(user.getEmail())
                .profilePictureUrl(user.getProfilePictureUrl())
                .followersCount(user.getFollowersCount())
                .followingCount(user.getFollowingCount())
                .phoneNumber(user.getPhoneNumber())
                .bio(user.getBio())
                .build();

        return userResponse;
    }


    @Override
    public void deleteUser(Long id) {
        userRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("User Not Found !")
        );
        userRepository.deleteById(id);
    }

    @Override
    public ResponseEntity<Object> updateUser(UserDTO userDTO ,Long id) throws IOException {
        User user = userRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("User Not Found")
        );

        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setBio(userDTO.getBio());
        user.setUsername(userDTO.getUsername());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setUsername(userDTO.getUsername());


//        String originalFilename = file.getOriginalFilename();
//        Path fileNameAndPath = Paths.get(uploadDirecory, originalFilename);
//        Files.write(fileNameAndPath, file.getBytes());
//        user.setProfilePictureUrl(originalFilename);

        return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
    }



    @Override
    public ResponseEntity<CommonResponse> registerUser(UserDTO userDTO) {

        User user = userRepository.findUserByEmail(userDTO.getEmail()).orElseThrow(
                () -> new EntityNotFoundException("User Alredy registered!")
        );
            user.setFirstName(userDTO.getFirstName());
            user.setLastName(userDTO.getLastName());
            user.setUsername(userDTO.getUsername());
            user.setEmail(userDTO.getEmail());
            user.setPasswordHash(userDTO.getPassword());
            user.setBio(userDTO.getBio());
            user.setAccountCreated(LocalTime.now());
            user.setSource("Authenticate");

            userRepository.save(user);

            CommonResponse commonResponse = new CommonResponse("Registered!");

return ResponseEntity.ok(commonResponse);

    }

    @Override
    public ResponseEntity<Object> loginUser(LoginDTO loginDTO) {
        User user = userRepository.findByEmail(loginDTO.getEmail());

        UserResponse userResponse = UserResponse.builder()
                .id(user.getUserId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .bio(user.getBio())
                .phoneNumber(user.getPhoneNumber())
                .profilePictureUrl(user.getProfilePictureUrl())
                .username(user.getUsername())
                .followersCount(user.getFollowersCount())
                .followingCount(user.getFollowingCount())
                .build();

        if (user == null){
            return new ResponseEntity<>("Invalid email", HttpStatus.UNAUTHORIZED);
        }
        if (passwordEncoder.matches( loginDTO.getPassword(), user.getPasswordHash())){

            return new ResponseEntity<>(userResponse, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Invalid password!",HttpStatus.UNAUTHORIZED);
        }
    }

}
