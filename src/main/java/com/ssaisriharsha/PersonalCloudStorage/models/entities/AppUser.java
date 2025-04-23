package com.ssaisriharsha.PersonalCloudStorage.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name="users")
@NoArgsConstructor
@Data
public class AppUser {
    @Id
    @Column(name="username")
    private String username;

    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @Column(name="createdOn")
    private LocalDateTime createdOn=LocalDateTime.now();
    @Column(name="banned", columnDefinition = "boolean default false")
    private boolean banned=false;
}
