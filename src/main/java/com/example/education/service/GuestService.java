package com.example.education.service;

import com.example.education.dto.request.GuestCreateUpdateRequest;
import com.example.education.dto.response.GuestResponse;
import com.example.education.model.GuestModel;

import java.util.List;
import java.util.UUID;

public interface GuestService {
    List<GuestResponse> getAll();

    GuestModel detail(UUID id);

    boolean create(GuestCreateUpdateRequest request);

    boolean update(UUID id, GuestCreateUpdateRequest request);

    boolean delete(UUID id);
}
