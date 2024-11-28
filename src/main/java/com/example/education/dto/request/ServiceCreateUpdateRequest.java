package com.example.education.dto.request;

import lombok.Data;


@Data
public class ServiceCreateUpdateRequest {
    private String serviceNo;

    private String serviceName;

    private double price;

    private double timeUsed;
}
