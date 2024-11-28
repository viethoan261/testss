package com.example.education.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class GuestCreateUpdateRequest {
    private String identifyCard;

    private String name;

    private LocalDate dob;

    private String studentId;
}
