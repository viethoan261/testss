//package com.example.education.controller;
//
//import com.example.education.common.util.ResponseHelper;
//import com.example.education.dto.request.UserUpdateRequest;
//import com.example.education.dto.response.ScheduleResponse;
//import com.example.education.dto.response.StatisticResponse;
//import com.example.education.model.UserModel;
//import com.example.education.service.UserService;
//import com.example.education.utils.enumm.RoleUser;
//import io.swagger.v3.oas.annotations.Operation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.servlet.http.HttpServletResponse;
//import javax.validation.Valid;
//import java.io.IOException;
//import java.util.List;
//import java.util.UUID;
//
//@RestController
//@RequestMapping("api/v1/users")
//@CrossOrigin(origins = {"http://localhost:5173/", "http://localhost:5174/", "http://localhost:3000/"})
//public class UserController {
//    @Autowired
//    private UserService userService;
//
//    @Operation(summary = "Update user")
//    @PostMapping("{id}")
//    public Object update(@PathVariable String id, @Valid @RequestBody UserUpdateRequest request,
//                         BindingResult result) {
//        if(result.hasErrors()) {
//            return ResponseHelper.getErrorResponse(result, HttpStatus.BAD_REQUEST);
//        }
//
//        Boolean res = userService.update(UUID.fromString(id), request);
//
//        if (!res) {
//            return ResponseHelper.getErrorResponse("Update fail", HttpStatus.BAD_REQUEST);
//        }
//
//        return ResponseHelper.getResponse(true, HttpStatus.OK);
//    }
//
//    @Operation(summary = "Delete user")
//    @PostMapping("{id}/delete")
//    public Object delete(@PathVariable String id) {
//        Boolean res = userService.delete(UUID.fromString(id));
//
//        if (!res) {
//            return ResponseHelper.getErrorResponse("Delete fail", HttpStatus.BAD_REQUEST);
//        }
//
//        return ResponseHelper.getResponse(true, HttpStatus.OK);
//    }
//
//    @Operation(summary = "change user")
//    @PostMapping("{id}/change-pwd")
//    public Object changePass(@PathVariable String id, @RequestBody String password) {
//        Boolean res = userService.changePassword(UUID.fromString(id), password);
//
//        if (!res) {
//            return ResponseHelper.getErrorResponse("Change password fail", HttpStatus.BAD_REQUEST);
//        }
//
//        return ResponseHelper.getResponse(true, HttpStatus.OK);
//    }
//
//    @Operation(summary = "Detail user")
//    @GetMapping("{id}")
//    public Object detail(@PathVariable String id) {
//        UserModel res = userService.findById(UUID.fromString(id));
//
//        if (res == null) {
//            return ResponseHelper.getErrorResponse("Khong tim thay user", HttpStatus.BAD_REQUEST);
//        }
//
//        return ResponseHelper.getResponse(res, HttpStatus.OK);
//    }
//
//    @Operation(summary = "Import user")
//    @PostMapping("import")
//    public Object importExcel(@RequestBody MultipartFile file, RoleUser role) throws IOException {
//        boolean res = userService.importExcel(file, role);
//
//        return ResponseHelper.getResponse(res, HttpStatus.OK);
//    }
//
//    @Operation(summary = "Export user to excel")
//    @GetMapping("export")
//    public void export(HttpServletResponse response, RoleUser role) {
//        userService.exportExcel(response, role);
//    }
//
//    @Operation(summary = "get schedule")
//    @GetMapping("{id}/schedule")
//    public Object getSchedule(@PathVariable String id) {
//        List<ScheduleResponse> res = userService.getSchedule(UUID.fromString(id));
//
//        return ResponseHelper.getResponse(res, HttpStatus.OK);
//    }
//
//    @Operation(summary = "get statistic")
//    @GetMapping("statistic")
//    public Object getStatistic() {
//        List<StatisticResponse> res = userService.getStatistic();
//
//        return ResponseHelper.getResponse(res, HttpStatus.OK);
//    }
//}
