package com.example.education.controller;

import com.example.education.common.util.ResponseHelper;
import com.example.education.dto.request.StudentCreateOrUpdateRequest;
import com.example.education.model.StudentModel;
import com.example.education.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/students")
@CrossOrigin(origins = {"http://localhost:5173/", "http://localhost:5174/", "http://localhost:3000/"})
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Operation(summary = "find all student")
    @GetMapping("")
    public Object findAll() {
        List<StudentModel> res = studentService.getAll();

        return ResponseHelper.getResponse(res, HttpStatus.OK);
    }

    @Operation(summary = "get student by id")
    @GetMapping("{id}")
    public Object detail(@PathVariable String id) {
        StudentModel res = studentService.detail(UUID.fromString(id));

        if (res == null) {
            return ResponseHelper.getErrorResponse("Khong tim thay student", HttpStatus.BAD_REQUEST);
        }

        return ResponseHelper.getResponse(res, HttpStatus.OK);
    }

    @PostMapping("")
    public Object create(@RequestBody @Valid StudentCreateOrUpdateRequest request) {
        Boolean res = studentService.create(request);

        if (!res) {
            return ResponseHelper.getErrorResponse("create fail", HttpStatus.BAD_REQUEST);
        }

        return ResponseHelper.getResponse(true, HttpStatus.OK);
    }

    @PostMapping("{id}")
    public Object update(@PathVariable String id, @RequestBody @Valid StudentCreateOrUpdateRequest request) {
        Boolean res = studentService.update(UUID.fromString(id), request);

        if (!res) {
            return ResponseHelper.getErrorResponse("update fail", HttpStatus.BAD_REQUEST);
        }

        return ResponseHelper.getResponse(true, HttpStatus.OK);
    }
}
