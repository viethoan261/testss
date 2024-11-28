package com.example.education.repository;

import com.example.education.model.UserModel;
import com.example.education.utils.enumm.RoleUser;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {
    @Query("select u from UserModel u where u.userName = :username and u.deleted = false")
    Optional<UserModel> findByUserName(String username);

    @Query("select u from UserModel u where u.id = :id and u.deleted = false")
    Optional<UserModel> findById(UUID id);

    @Query("select u from UserModel u where u.deleted = false and u.role = 'ROLE_TEACHER'")
    List<UserModel> findAllTeacher();

    @Query("select u from UserModel u where u.deleted = false and u.role = 'ROLE_STUDENT' and u.id in :ids")
    List<UserModel> findAllStudent(List<UUID> ids);

    @Query("select u from UserModel u where u.deleted = false and u.role = 'ROLE_STUDENT'")
    List<UserModel> findAllStudent();

    @Query("select u from UserModel u where u.deleted = false and u.role = :role")
    List<UserModel> findByRole(RoleUser role);
}
