package com.ssaisriharsha.PersonalCloudStorage.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import java.time.LocalDateTime;

@Entity
@Table(name="users")
@NoArgsConstructor
@Data
public class AppUser {
    @Id
    @Column(name="username")
    private String username;
    @Email
    @Column(name="email", unique = true)
    @NotNull
    private String email;
    @Size(min=10)
    @Column(name="password")
    private String password;
    @Column(name="createdOn")
    private LocalDateTime createdOn=LocalDateTime.now();
    @Column(name="banned", columnDefinition = "boolean default false")
    private boolean banned=false;
}
