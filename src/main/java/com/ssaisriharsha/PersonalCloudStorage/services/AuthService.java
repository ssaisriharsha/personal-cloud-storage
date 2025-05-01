package com.ssaisriharsha.PersonalCloudStorage.services;

import com.ssaisriharsha.PersonalCloudStorage.Exceptions.UserExistsException;
import com.ssaisriharsha.PersonalCloudStorage.models.entities.AppUser;
import com.ssaisriharsha.PersonalCloudStorage.models.repositories.AppUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class AuthService {
    private final AppUserRepository repo;
    private final PasswordEncoder encoder;
    public AuthService(AppUserRepository repo, PasswordEncoder encoder) {
        this.repo=repo;
        this.encoder=encoder;
    }
    @Transactional
    public void createUser(AppUser user) {
        if(repo.existsById(user.getUsername())) throw new UserExistsException("The user with the username " + user.getUsername()+" already exists. Kindly choose another username");
        user.setPassword(encoder.encode(user.getPassword()));
        user.setBanned(false);
        repo.save(user);
    }
}
