package com.ssaisriharsha.PersonalCloudStorage.controllers;

import com.ssaisriharsha.PersonalCloudStorage.models.entities.AppUser;
import com.ssaisriharsha.PersonalCloudStorage.services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class AuthController {
    private final AuthService authService;
    public AuthController(AuthService authService) {
        this.authService=authService;
    }
    @PostMapping("/signup")
    public ResponseEntity<HashMap<String, String>> signupResponse(@RequestBody AppUser user) {
        authService.createUser(user);
        HashMap<String, String> map=new HashMap<>();
        map.put("message", "User with username "+ user.getUsername()+" created successfully. You may proceed to login now.");
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }
}
