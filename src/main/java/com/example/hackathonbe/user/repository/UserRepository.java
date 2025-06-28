package com.example.hackathonbe.user.repository;

import com.example.hackathonbe.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
