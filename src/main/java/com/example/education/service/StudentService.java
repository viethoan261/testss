package com.example.education.service;

import com.example.education.dto.request.StudentCreateOrUpdateRequest;
import com.example.education.model.StudentModel;

import java.util.List;
import java.util.UUID;

public interface StudentService {
    List<StudentModel> getAll();

    StudentModel detail(UUID id);

    boolean create(StudentCreateOrUpdateRequest request);

    boolean update(UUID id, StudentCreateOrUpdateRequest request);
}
