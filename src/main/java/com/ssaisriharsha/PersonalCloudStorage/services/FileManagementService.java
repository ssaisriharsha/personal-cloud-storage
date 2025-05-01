package com.ssaisriharsha.PersonalCloudStorage.services;

import com.ssaisriharsha.PersonalCloudStorage.DTOs.FileDTO;
import com.ssaisriharsha.PersonalCloudStorage.models.entities.AppUser;
import com.ssaisriharsha.PersonalCloudStorage.models.entities.UserFile;
import com.ssaisriharsha.PersonalCloudStorage.models.repositories.FileRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.time.LocalDateTime;

@Service
public class FileManagementService {
    private final FileRepository repo;
    public FileManagementService(FileRepository repo) {
         this.repo=repo;
    }
    @Transactional(rollbackFor=IOException.class)
    public FileDTO saveFileInFs(MultipartFile mpfile, AppUser user, String overwrite) throws IOException {
        File uploadDir=new File("/home/sai/Desktop/uploads/"+user.getUsername());
        if(!uploadDir.exists()) uploadDir.mkdirs();
        File uploadedFile=new File(uploadDir.getPath(), mpfile.getOriginalFilename());
        if(uploadedFile.exists()) {
            if(overwrite.equals("false")) throw new FileAlreadyExistsException(uploadedFile.getName());
            return new FileDTO(updateFileInDb(mpfile, user));
        }
        mpfile.transferTo(uploadedFile);
        return new FileDTO(saveFileInDb(mpfile, user));
    }
//    @Transactional
    protected UserFile saveFileInDb(MultipartFile mpfile, AppUser user) {
        UserFile userFile=new UserFile();
        userFile.setUser(user);
        userFile.setName(mpfile.getOriginalFilename());
        userFile.setSize(mpfile.getSize());
        return repo.save(userFile);
    }
    protected UserFile updateFileInDb(MultipartFile mpfile, AppUser user) {
        UserFile userFile=repo.findUserFileByNameAndUser_Username(mpfile.getOriginalFilename(), user.getUsername()).get();
        userFile.setModifiedOn(LocalDateTime.now());
        userFile.setSize(mpfile.getSize());
        return repo.save(userFile);
    }
}
