package com.example.hackathonbe.user.repository;

import com.example.hackathonbe.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByLoginId(String loginId);
  
    List<UserEntity> findByLoginIdContaining(String query);
}
