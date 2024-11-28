package com.example.education.service;

import com.example.education.dto.request.ServiceCreateUpdateRequest;
import com.example.education.model.ServiceModel;

import java.util.List;
import java.util.UUID;

public interface ServiceModelService {
    List<ServiceModel> getAll();

    ServiceModel detail(UUID id);

    boolean create(ServiceCreateUpdateRequest request);

    boolean update(UUID id, ServiceCreateUpdateRequest request);

    boolean delete(UUID id);
}
