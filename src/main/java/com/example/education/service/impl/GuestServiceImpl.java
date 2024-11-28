package com.example.education.service.impl;

import com.example.education.dto.request.GuestCreateUpdateRequest;
import com.example.education.dto.request.RoomCreateUpdateRequest;
import com.example.education.model.GuestModel;
import com.example.education.model.RoomModel;
import com.example.education.repository.GuestRepository;
import com.example.education.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GuestServiceImpl implements GuestService {
    @Autowired
    private GuestRepository guestRepository;

    @Override
    public List<GuestModel> getAll() {
        return guestRepository.findAll();
    }

    @Override
    public GuestModel detail(UUID id) {
        Optional<GuestModel> guestModel = guestRepository.findById(id);

        return guestModel.orElse(null);
    }

    @Override
    public boolean create(GuestCreateUpdateRequest request) {
        GuestModel guestModel = new GuestModel();

        guestModel.setDob(request.getDob());
        guestModel.setIdentifyCard(request.getIdentifyCard());
        guestModel.setStudentId(request.getStudentId());
        guestModel.setName(request.getName());

        guestRepository.save(guestModel);
        return true;
    }

    @Override
    public boolean update(UUID id, GuestCreateUpdateRequest request) {
        Optional<GuestModel> guestModel = guestRepository.findById(id);

        if (guestModel.isEmpty()) return false;

        GuestModel guest = guestModel.get();
        guest.setDob(request.getDob());
        guest.setIdentifyCard(request.getIdentifyCard());
        guest.setStudentId(request.getStudentId());
        guest.setName(request.getName());

        guestRepository.save(guest);
        return true;
    }

    @Override
    public boolean delete(UUID id) {
        guestRepository.deleteById(id);
        return true;
    }
}
