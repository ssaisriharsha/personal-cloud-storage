package com.ssaisriharsha.PersonalCloudStorage.controllers;

import com.ssaisriharsha.PersonalCloudStorage.DTOs.FileDTO;
import com.ssaisriharsha.PersonalCloudStorage.Exceptions.InvalidRequestParameterException;
import com.ssaisriharsha.PersonalCloudStorage.SecurityConfig.AppUserDetails;
import com.ssaisriharsha.PersonalCloudStorage.models.entities.UserFile;
import com.ssaisriharsha.PersonalCloudStorage.services.FileManagementService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1")
public class FileOperationsController {
    private final FileManagementService service;
    public FileOperationsController(FileManagementService service) {
        this.service=service;
    }
    @PostMapping("/upload")
    public ResponseEntity<FileDTO> handleUploads(@RequestParam("file") MultipartFile mpfile, @AuthenticationPrincipal AppUserDetails details, @RequestParam(name="overwrite", defaultValue="false") String overwrite) throws IOException {
        if(!(overwrite.equalsIgnoreCase("false")||overwrite.equalsIgnoreCase("true"))) throw new InvalidRequestParameterException("overwrite parameter can only be true or false");
        FileDTO file=service.saveFileInFs(mpfile, details.getUser(), overwrite.toLowerCase());
        return ResponseEntity.ok(file);
    }
}
