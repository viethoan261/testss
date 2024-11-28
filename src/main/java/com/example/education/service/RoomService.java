package com.example.education.service;

import com.example.education.dto.request.RoomCreateUpdateRequest;
import com.example.education.model.RoomModel;

import java.util.List;
import java.util.UUID;

public interface RoomService {
    List<RoomModel> getAll();

    RoomModel detail(UUID id);

    boolean create(RoomCreateUpdateRequest request);

    boolean update(UUID id, RoomCreateUpdateRequest request);
}
