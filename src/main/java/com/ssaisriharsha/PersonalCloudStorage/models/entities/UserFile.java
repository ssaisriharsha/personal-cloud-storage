package com.ssaisriharsha.PersonalCloudStorage.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
@Table(name="files")
public class UserFile {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private final LocalDateTime createdOn=LocalDateTime.now();
    private LocalDateTime modifiedOn=LocalDateTime.now();
    private long size;
    @ManyToOne
    @JoinColumn(name="username")
    private AppUser user;
}
