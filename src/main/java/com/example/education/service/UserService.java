//package com.example.education.service;
//
//import com.example.education.dto.request.UserUpdateRequest;
//import com.example.education.dto.response.ScheduleResponse;
//import com.example.education.dto.response.StatisticResponse;
//import com.example.education.model.UserModel;
//import com.example.education.utils.enumm.RoleUser;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//import java.util.UUID;
//
///**
// * @author : Admin
// * @created : 8/19/2023, Saturday
// **/
//public interface UserService {
//    boolean update(UUID id, UserUpdateRequest request);
//
//    boolean delete(UUID id);
//
//    boolean changePassword(UUID id, String password);
//
//    UserModel findById(UUID id);
//
//    boolean importExcel(MultipartFile file, RoleUser role) throws IOException;
//
//    void exportExcel(HttpServletResponse response, RoleUser role);
//
//    List<ScheduleResponse> getSchedule(UUID id);
//
//    List<StatisticResponse> getStatistic();
//}
