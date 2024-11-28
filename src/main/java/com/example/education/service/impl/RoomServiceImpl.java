package com.example.education.service.impl;

import com.example.education.dto.request.RoomCreateUpdateRequest;
import com.example.education.dto.request.StudentCreateOrUpdateRequest;
import com.example.education.model.RoomModel;
import com.example.education.model.StudentModel;
import com.example.education.repository.RoomRepository;
import com.example.education.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List<RoomModel> getAll() {
        return roomRepository.findAll();
    }

    @Override
    public RoomModel detail(UUID id) {
        Optional<RoomModel> roomOpt = roomRepository.findById(id);

        return roomOpt.orElse(null);
    }

    @Override
    public boolean create(RoomCreateUpdateRequest request) {
        RoomModel roomModel = new RoomModel();

        roomModel.setRoomNo(request.getRoomNo());
        roomModel.setCapacity(request.getCapacity());
        roomModel.setPrice(request.getPrice());

        roomRepository.save(roomModel);
        return true;
    }

    @Override
    public boolean update(UUID id, RoomCreateUpdateRequest request) {
        Optional<RoomModel> roomModelOptional = roomRepository.findById(id);

        if (roomModelOptional.isEmpty()) return false;

        RoomModel roomModel = roomModelOptional.get();
        roomModel.setPrice(request.getPrice());
        roomModel.setRoomNo(request.getRoomNo());
        roomModel.setCapacity(request.getCapacity());

        roomRepository.save(roomModel);
        return true;
    }

    @Override
    public boolean delete(UUID id) {
        roomRepository.deleteById(id);
        return true;
    }
}
