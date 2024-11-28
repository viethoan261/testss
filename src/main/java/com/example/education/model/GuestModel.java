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
@Table(name = "guest")
public class GuestModel extends BaseEntity {
    @Column(name = "identify_card", nullable = false)
    private String identifyCard;

    @Column(name = "name", nullable = false)
    private String name;

    private LocalDate dob;

    @Column(name = "student_id", nullable = false)
    private String studentId;
}
