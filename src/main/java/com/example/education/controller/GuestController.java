package com.example.education.controller;

import com.example.education.common.util.ResponseHelper;
import com.example.education.dto.request.GuestCreateUpdateRequest;
import com.example.education.dto.request.RoomCreateUpdateRequest;
import com.example.education.model.GuestModel;
import com.example.education.model.RoomModel;
import com.example.education.service.GuestService;
import com.example.education.service.RoomService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/guests")
@CrossOrigin(origins = {"http://localhost:5173/", "http://localhost:5174/", "http://localhost:3000/"})
public class GuestController {
    @Autowired
    private GuestService guestService;

    @Operation(summary = "find all guest")
    @GetMapping("")
    public Object findAll() {
        List<GuestModel> res = guestService.getAll();

        return ResponseHelper.getResponse(res, HttpStatus.OK);
    }

    @Operation(summary = "get guest by id")
    @GetMapping("{id}")
    public Object detail(@PathVariable String id) {
        GuestModel res = guestService.detail(UUID.fromString(id));

        if (res == null) {
            return ResponseHelper.getErrorResponse("Khong tim thay guest", HttpStatus.BAD_REQUEST);
        }

        return ResponseHelper.getResponse(res, HttpStatus.OK);
    }

    @PostMapping("")
    public Object create(@RequestBody @Valid GuestCreateUpdateRequest request) {
        Boolean res = guestService.create(request);

        if (!res) {
            return ResponseHelper.getErrorResponse("create fail", HttpStatus.BAD_REQUEST);
        }

        return ResponseHelper.getResponse(true, HttpStatus.OK);
    }

    @PostMapping("{id}")
    public Object update(@PathVariable String id, @RequestBody @Valid GuestCreateUpdateRequest request) {
        Boolean res = guestService.update(UUID.fromString(id), request);

        if (!res) {
            return ResponseHelper.getErrorResponse("update fail", HttpStatus.BAD_REQUEST);
        }

        return ResponseHelper.getResponse(true, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public Object delete(@PathVariable String id) {
        return ResponseHelper.getResponse(guestService.delete(UUID.fromString(id)), HttpStatus.OK);
    }
}
