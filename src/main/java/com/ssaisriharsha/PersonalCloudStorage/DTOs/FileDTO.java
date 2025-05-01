package com.ssaisriharsha.PersonalCloudStorage.DTOs;

import com.ssaisriharsha.PersonalCloudStorage.models.entities.UserFile;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class FileDTO {
    private long id;
    private String name;
    private LocalDateTime createdOn;
    private long size;
    private LocalDateTime modifiedOn;
    public FileDTO(UserFile file) {
        this.id=file.getId();
        this.createdOn=file.getCreatedOn();
        this.name=file.getName();
        this.size=file.getSize();
        this.modifiedOn=file.getModifiedOn();
    }
}
