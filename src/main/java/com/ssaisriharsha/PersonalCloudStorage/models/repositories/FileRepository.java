package com.ssaisriharsha.PersonalCloudStorage.models.repositories;

import com.ssaisriharsha.PersonalCloudStorage.models.entities.UserFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileRepository extends JpaRepository<UserFile, Long> {
    Optional<UserFile> findUserFileByNameAndUser_Username(String name, String userUsername);
}
