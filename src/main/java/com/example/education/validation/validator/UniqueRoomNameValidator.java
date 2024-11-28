//package com.example.education.validation.validator;
//
//import com.example.education.model.RoomModel;
//import com.example.education.validation.annotation.UniqueRoomName;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import javax.validation.ConstraintValidator;
//import javax.validation.ConstraintValidatorContext;
//import java.util.Optional;
//
//public class UniqueRoomNameValidator implements ConstraintValidator<UniqueRoomName, String> {
//    @Autowired
//    private RoomRepository repository;
//
//    private String message;
//
//    @Override
//    public void initialize(UniqueRoomName uniqueRoomName) {
//        message = uniqueRoomName.message();
//    }
//
//    @Override
//    public boolean isValid(String roomName, ConstraintValidatorContext context) {
//        if(roomName == null)
//            return false;
//
//        Optional<RoomModel> roomOtp = repository.findRoomByName(roomName);
//
//        if(roomOtp.isEmpty()) {
//            return true;
//        }
//
//        context.buildConstraintViolationWithTemplate(message)
//                .addConstraintViolation()
//                .disableDefaultConstraintViolation();
//        return false;
//    }
//}
