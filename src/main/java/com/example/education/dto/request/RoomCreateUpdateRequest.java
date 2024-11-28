package com.example.education.dto.request;

import lombok.Data;

@Data
public class RoomCreateUpdateRequest {
    private String roomNo;

    private Double price;

    private int capacity;
}
