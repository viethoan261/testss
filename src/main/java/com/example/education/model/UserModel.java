package com.example.education.model;

import com.example.education.common.model.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "user")
public class UserModel extends BaseEntity {
    @Column(name = "username", unique = true, nullable = false, length = 50)
    private String userName;

    @Column(name = "password", nullable = false, length = 100)
    @JsonIgnore
    private String password;

    @Column(name = "full_name", length = 50, nullable = false)
    private String fullName;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "phone_number", length = 50)
    private String phoneNumber;

    @Column(name = "date_of_birth")
    private LocalDate dob;

    @Column(name = "deleted", nullable = false)
    private Boolean deleted = Boolean.FALSE;

    private String description;

    private String image;
}
