package com.example.education.model;

import com.example.education.common.model.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "student")
public class StudentModel extends BaseEntity {
    @Column(name = "student_no", nullable = false)
    private String studentNo;

    @Column(name = "identify_card", nullable = false)
    private String identifyCard;

    @Column(name = "class_name", nullable = false)
    private String className;

    private LocalDate dob;

    private String hometown;

    private String name;
}
