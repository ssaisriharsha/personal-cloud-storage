package com.ssaisriharsha.PersonalCloudStorage.models.repositories;

import com.ssaisriharsha.PersonalCloudStorage.models.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, String> {

}
