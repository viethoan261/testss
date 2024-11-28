package com.example.education.dto.request;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDate;

@Data
public class StudentCreateOrUpdateRequest {
    private String studentNo;

    private String identifyCard;

    private String className;

    private LocalDate dob;

    private String hometown;

    private String name;
}
