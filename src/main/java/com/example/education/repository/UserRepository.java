package com.example.education.repository;

import com.example.education.model.UserModel;
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
}
