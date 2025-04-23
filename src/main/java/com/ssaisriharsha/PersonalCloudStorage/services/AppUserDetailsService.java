package com.ssaisriharsha.PersonalCloudStorage.services;

import com.ssaisriharsha.PersonalCloudStorage.SecurityConfig.AppUserDetails;
import com.ssaisriharsha.PersonalCloudStorage.models.entities.AppUser;
import com.ssaisriharsha.PersonalCloudStorage.models.repositories.AppUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsService implements UserDetailsService {
    public final AppUserRepository appUserRepository;
    public AppUserDetailsService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user=appUserRepository.findById(username)
                .orElseThrow(()->new UsernameNotFoundException("Incorrect username/password"));
        return new AppUserDetails(user);
    }

}
