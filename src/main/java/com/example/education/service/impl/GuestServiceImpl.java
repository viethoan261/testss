package com.example.education.service.impl;

import com.example.education.dto.request.GuestCreateUpdateRequest;
import com.example.education.dto.request.RoomCreateUpdateRequest;
import com.example.education.dto.response.GuestResponse;
import com.example.education.model.GuestModel;
import com.example.education.model.RoomModel;
import com.example.education.model.StudentModel;
import com.example.education.repository.GuestRepository;
import com.example.education.repository.StudentRepository;
import com.example.education.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GuestServiceImpl implements GuestService {
    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<GuestResponse> getAll() {
        List<GuestModel> guestModels = guestRepository.findAll();
        List<GuestResponse> res = new ArrayList<>();
        for (GuestModel guestModel : guestModels) {
            GuestResponse guestResponse = new GuestResponse();
            Optional<StudentModel> studentModel = studentRepository.findById(UUID.fromString(guestModel.getStudentId()));

            studentModel.ifPresent(model -> guestResponse.setStudentName(model.getName()));
            guestResponse.setIdentifyCard(guestModel.getIdentifyCard());
            guestResponse.setId(guestModel.getId());
            guestResponse.setDob(guestModel.getDob());
            guestResponse.setName(guestModel.getName());

            res.add(guestResponse);
        }
        return res;
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
