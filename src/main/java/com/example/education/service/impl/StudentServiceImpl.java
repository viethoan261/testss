package com.example.education.service.impl;

import com.example.education.dto.request.StudentCreateOrUpdateRequest;
import com.example.education.model.*;
import com.example.education.repository.*;
import com.example.education.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<StudentModel> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public StudentModel detail(UUID id) {
        Optional<StudentModel> studentOpt = studentRepository.findById(id);

        return studentOpt.orElse(null);
    }

    @Override
    public boolean create(StudentCreateOrUpdateRequest request) {
        StudentModel studentModel = new StudentModel();

        studentModel.setStudentNo(request.getStudentNo());
        studentModel.setDob(request.getDob());
        studentModel.setHometown(request.getHometown());
        studentModel.setClassName(request.getClassName());
        studentModel.setIdentifyCard(request.getIdentifyCard());

        studentRepository.save(studentModel);
        return true;
    }

    @Override
    public boolean update(UUID id, StudentCreateOrUpdateRequest request) {
        Optional<StudentModel> studentOpt = studentRepository.findById(id);

        if (studentOpt.isEmpty()) return false;

        StudentModel studentModel = studentOpt.get();
        studentModel.setDob(request.getDob());
        studentModel.setStudentNo(request.getStudentNo());
        studentModel.setHometown(request.getHometown());
        studentModel.setClassName(request.getClassName());
        studentModel.setIdentifyCard(request.getIdentifyCard());

        studentRepository.save(studentModel);
        return true;
    }

    @Override
    public boolean delete(UUID id) {
        studentRepository.deleteById(id);
        return true;
    }


}
