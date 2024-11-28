//package com.example.education.service.impl;
//
//import com.example.education.common.util.ExcelUtils;
//import com.example.education.common.util.StringPool;
//import com.example.education.model.*;
//import com.example.education.repository.*;
//import com.example.education.service.UserService;
//import com.example.education.utils.enumm.RoleUser;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellStyle;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.util.IOUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.multipart.MultipartFile;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import javax.servlet.http.HttpServletResponse;
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.text.SimpleDateFormat;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Objects;
//import java.util.Optional;
//import java.util.UUID;
//import java.util.stream.Collectors;
//
//@Service
//public class UserServiceImpl implements UserService {
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Override
//    @Transactional
//    public boolean update(UUID id, UserUpdateRequest request) {
//        Optional<UserModel> userOpt = userRepository.findById(id);
//
//        if (userOpt.isEmpty()) {
//            return false;
//        }
//
//        UserModel user = userOpt.get();
//
//        user.setFullName(request.getFullName());
//        user.setEmail(request.getEmail());
//        user.setPhoneNumber(request.getPhoneNumber());
//        user.setDob(request.getDob());
//        user.setDescription(request.getDescription());
//        user.setImage(request.getImage());
//
//        userRepository.save(user);
//
//        return true;
//    }
//
//    @Override
//    public boolean delete(UUID id) {
//        Optional<UserModel> userOpt = userRepository.findById(id);
//
//        if (userOpt.isEmpty()) {
//            return false;
//        }
//
//        UserModel user = userOpt.get();
//
//        user.setDeleted(Boolean.TRUE);
//
//        userRepository.save(user);
//
//        return true;
//    }
//
//    @Override
//    public boolean changePassword(UUID id, String password) {
//        Optional<UserModel> userOpt = userRepository.findById(id);
//
//        if (userOpt.isEmpty()) {
//            return false;
//        }
//
//        UserModel user = userOpt.get();
//
//        user.setPassword(passwordEncoder.encode(password));
//
//        userRepository.save(user);
//
//        return true;
//    }
//
//    @Override
//    public UserModel findById(UUID id) {
//        Optional<UserModel> userOpt = userRepository.findById(id);
//
//        if (userOpt.isEmpty()) {
//            return null;
//        }
//
//        UserModel user = userOpt.get();
//
//        return user;
//    }
//
//    @Override
//    @Transactional
//    public boolean importExcel(MultipartFile file, RoleUser role) throws IOException {
//        List<UserModel> users = new ArrayList<>();
//
//        File tempFile = File.createTempFile("temp-", ".xlsx");
//        file.transferTo(tempFile);
//        // Đọc file Excel và lưu thông tin vào cơ sở dữ liệu ở đây
//        FileInputStream excelFile = new FileInputStream(tempFile);
//        Workbook workbook = new XSSFWorkbook(excelFile);
//        Sheet sheet = workbook.getSheetAt(0);
//
//        for (int rowIndex = 2; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
//            Row row = sheet.getRow(rowIndex);
//
//            // Xử lý từng dòng của file Excel và lưu vào cơ sở dữ liệu
//            UserModel newUser = new UserModel();
//
//            newUser.setPassword(passwordEncoder.encode("123456"));
//            newUser.setFullName(row.getCell(1).getStringCellValue());
//            newUser.setDob(LocalDate.parse(row.getCell(2).getStringCellValue()));
//            newUser.setEmail(row.getCell(3).getStringCellValue());
//            newUser.setPhoneNumber(row.getCell(4).getStringCellValue());
//            newUser.setUserName(row.getCell(5).getStringCellValue());
//            newUser.setRole(role);
//
//            users.add(newUser);
//        }
//
//        workbook.close();
//        excelFile.close();
//
//        for (UserModel user : users) {
//            if (userRepository.findByUserName(user.getUserName()).isEmpty()) {
//                userRepository.save(user);
//            }
//        }
//
//        return true;
//    }
//
//    @Override
//    public void exportExcel(HttpServletResponse response, RoleUser role) {
//        InputStream data = Objects.requireNonNull(this.getClass().getClassLoader().getResourceAsStream(TEMPLATE_USER_FILE_PATH));
//        String type;
//
//        if (role.equals(RoleUser.ROLE_STUDENT)) {
//            type = "HỌC VIÊN";
//            TEMPLATE_USER_FILE_NAME = "Danh_sach_hoc_vien";
//        } else if (role.equals(RoleUser.ROLE_TEACHER)) {
//            type = "GIÁO VIÊN";
//            TEMPLATE_USER_FILE_NAME = "Danh_sach_giao_vien";
//        } else {
//            type = "người dùng";
//        }
//
//        List<UserModel> userModels = userRepository.findByRole(role);
//
//        XSSFWorkbook workbook;
//
//        try {
//            workbook = new XSSFWorkbook(data);
//        } catch (IOException e) {
//            throw new RuntimeException("Open file fail!!");
//        }
//
//        Sheet userSheet = workbook.getSheetAt(TEMPLATE_USER_SHEET_NUMBER);
//
//        if (Objects.isNull(userSheet)) {
//            throw new RuntimeException("DEPARTMENT_SHEET_TEMPLATE_REQUIRED");
//        }
//
//        String title = "DANH SÁCH " + type.toUpperCase();
//
//        // Thêm tiêu đề vào file Excel
//        Row titleRow = userSheet.getRow(0);
//        CellStyle titleCellStyle = ExcelUtils.createTitleCellStyle(workbook); // Tạo cell style cho tiêu đề
//        Cell titleCell = titleRow.createCell(0);
//        titleCell.setCellValue(title);
//        titleCell.setCellStyle(titleCellStyle);
//
//        for (int i = 0; i < userModels.size(); i++) {
//            UserModel user = userModels.get(i);
//
//            Row currentRow = userSheet.createRow(DEPARTMENT_START_ROW + i);
//
//            CellStyle cellStyle = ExcelUtils.createValueCellStyle(workbook);
//
//            ExcelUtils.createCell(currentRow, 0, cellStyle, String.valueOf(i + 1));
//            ExcelUtils.createCell(currentRow, 1, cellStyle, user.getFullName());
//            ExcelUtils.createCell(currentRow, 2, cellStyle, user.getDob() != null ? user.getDob().toString() : "N/A");
//            ExcelUtils.createCell(currentRow, 3, cellStyle, user.getEmail());
//            ExcelUtils.createCell(currentRow, 4, cellStyle, user.getPhoneNumber());
//            ExcelUtils.createCell(currentRow, 5, cellStyle, type);
//        }
//
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//        try {
//            String filename = TEMPLATE_USER_FILE_NAME + StringPool.UNDERLINE + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) +
//                    StringPool.XLSX;
//            workbook.write(out);
//            response.setHeader("Content-Type", "application/octet-stream");
//            response.setHeader("Content-Disposition", " attachment; filename=" + filename);
//            IOUtils.copy(new ByteArrayInputStream(out.toByteArray()), response.getOutputStream());
//            response.flushBuffer();
//            out.close();
//            workbook.close();
//        } catch (IOException e) {
//            throw new RuntimeException("Download template fail!!");
//
//        }
//    }
//
//    @Override
//    public List<ScheduleResponse> getSchedule(UUID id) {
//        UserModel user = userRepository.findById(id).get();
//        List<ScheduleResponse> res = new ArrayList<>();
//
//        if (user.getRole().equals(RoleUser.ROLE_STUDENT)) {
//            return getScheduleStudent(id, res);
//        }
//
//        if (user.getRole().equals(RoleUser.ROLE_TEACHER)) {
//            return getScheduleTeacher(id, res);
//        }
//        return res;
//    }
//
//    @Override
//    public List<StatisticResponse> getStatistic() {
//        List<StatisticResponse> res = new ArrayList<>();
//        List<CourseModel> courses = courseRepository.findAll();
//
//        for (CourseModel course : courses) {
//            StatisticResponse statisticResponse = new StatisticResponse();
//
//            List<StudentCourseModel> studentCourseModels = studentCourseRepository.findAllByCourseId(course.getId());
//            UserModel teacher = userRepository.findById(course.getTeacherId()).get();
//
//            statisticResponse.setCourseName(course.getName());
//            statisticResponse.setCourseId(course.getId());
//            statisticResponse.setMembers(studentCourseModels.size());
//            statisticResponse.setTeacherName(teacher.getFullName());
//
//            res.add(statisticResponse);
//        }
//        return res;
//    }
//
//    private List<ScheduleResponse> getScheduleStudent(UUID id, List<ScheduleResponse> res) {
//        List<StudentCourseModel> studentCourseModels = studentCourseRepository.findAllByStudentId(id);
//        List<UUID> courseIds = studentCourseModels.stream().map(StudentCourseModel::getCourseId).collect(Collectors.toList());
//
//        List<CourseModel> courses = courseRepository.findAllById(courseIds);
//
//        for (CourseModel course : courses) {
//            List<TimeTableModel> timeTableModels = timeTableRepository.findByCourseID(course.getId());
//            RoomModel roomModel = roomRepository.findById(course.getRoomId()).get();
//
//            ScheduleResponse scheduleResponse = new ScheduleResponse();
//
//            scheduleResponse.setTimeTables(timeTableModels);
//            scheduleResponse.setCourseName(course.getName());
//            scheduleResponse.setRoomName(roomModel.getName());
//
//            res.add(scheduleResponse);
//        }
//
//        return res;
//
//    }
//
//    private List<ScheduleResponse> getScheduleTeacher(UUID id, List<ScheduleResponse> res) {
//        List<CourseModel> courses = courseRepository.findAllByTeacherID(id);
//        for (CourseModel course : courses) {
//            List<TimeTableModel> timeTableModels = timeTableRepository.findByCourseID(course.getId());
//            RoomModel roomModel = roomRepository.findById(course.getRoomId()).get();
//
//            ScheduleResponse scheduleResponse = new ScheduleResponse();
//
//            scheduleResponse.setTimeTables(timeTableModels);
//            scheduleResponse.setCourseName(course.getName());
//            scheduleResponse.setRoomName(roomModel.getName());
//
//            res.add(scheduleResponse);
//        }
//
//        return res;
//    }
//}
