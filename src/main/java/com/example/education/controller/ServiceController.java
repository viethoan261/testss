package com.example.education.controller;

import com.example.education.common.util.ResponseHelper;
import com.example.education.dto.request.GuestCreateUpdateRequest;
import com.example.education.dto.request.ServiceCreateUpdateRequest;
import com.example.education.model.GuestModel;
import com.example.education.model.ServiceModel;
import com.example.education.service.GuestService;
import com.example.education.service.ServiceModelService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/services")
@CrossOrigin(origins = {"http://localhost:5173/", "http://localhost:5174/", "http://localhost:3000/"})
public class ServiceController {
    @Autowired
    private ServiceModelService serviceModelService;

    @Operation(summary = "find all service")
    @GetMapping("")
    public Object findAll() {
        List<ServiceModel> res = serviceModelService.getAll();

        return ResponseHelper.getResponse(res, HttpStatus.OK);
    }

    @Operation(summary = "get service by id")
    @GetMapping("{id}")
    public Object detail(@PathVariable String id) {
        ServiceModel res = serviceModelService.detail(UUID.fromString(id));

        if (res == null) {
            return ResponseHelper.getErrorResponse("Khong tim thay service", HttpStatus.BAD_REQUEST);
        }

        return ResponseHelper.getResponse(res, HttpStatus.OK);
    }

    @PostMapping("")
    public Object create(@RequestBody @Valid ServiceCreateUpdateRequest request) {
        Boolean res = serviceModelService.create(request);

        if (!res) {
            return ResponseHelper.getErrorResponse("create fail", HttpStatus.BAD_REQUEST);
        }

        return ResponseHelper.getResponse(true, HttpStatus.OK);
    }

    @PostMapping("{id}")
    public Object update(@PathVariable String id, @RequestBody @Valid ServiceCreateUpdateRequest request) {
        Boolean res = serviceModelService.update(UUID.fromString(id), request);

        if (!res) {
            return ResponseHelper.getErrorResponse("update fail", HttpStatus.BAD_REQUEST);
        }

        return ResponseHelper.getResponse(true, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public Object delete(@PathVariable String id) {
        return ResponseHelper.getResponse(serviceModelService.delete(UUID.fromString(id)), HttpStatus.OK);
    }
}
