package com.example.education.controller;

import com.example.education.common.util.ResponseHelper;
import com.example.education.dto.request.RoomCreateUpdateRequest;
import com.example.education.model.RoomModel;
import com.example.education.service.RoomService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/rooms")
@CrossOrigin(origins = {"http://localhost:5173/", "http://localhost:5174/", "http://localhost:3000/"})
public class RoomController {
    @Autowired
    private RoomService roomService;

    @Operation(summary = "find all room")
    @GetMapping("")
    public Object findAll() {
        List<RoomModel> res = roomService.getAll();

        return ResponseHelper.getResponse(res, HttpStatus.OK);
    }

    @Operation(summary = "get room by id")
    @GetMapping("{id}")
    public Object detail(@PathVariable String id) {
        RoomModel res = roomService.detail(UUID.fromString(id));

        if (res == null) {
            return ResponseHelper.getErrorResponse("Khong tim thay room", HttpStatus.BAD_REQUEST);
        }

        return ResponseHelper.getResponse(res, HttpStatus.OK);
    }

    @PostMapping("")
    public Object create(@RequestBody @Valid RoomCreateUpdateRequest request) {
        Boolean res = roomService.create(request);

        if (!res) {
            return ResponseHelper.getErrorResponse("create fail", HttpStatus.BAD_REQUEST);
        }

        return ResponseHelper.getResponse(true, HttpStatus.OK);
    }

    @PostMapping("{id}")
    public Object update(@PathVariable String id, @RequestBody @Valid RoomCreateUpdateRequest request) {
        Boolean res = roomService.update(UUID.fromString(id), request);

        if (!res) {
            return ResponseHelper.getErrorResponse("update fail", HttpStatus.BAD_REQUEST);
        }

        return ResponseHelper.getResponse(true, HttpStatus.OK);
    }
}
