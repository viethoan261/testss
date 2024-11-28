package com.example.education.dto.response;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class GuestResponse {
    private UUID id;

    private String identifyCard;

    private String name;

    private LocalDate dob;

    private String studentName;
}
