package com.example.hackathonbe.notification.repository;

import com.example.hackathonbe.notification.entity.AlarmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlarmRepository extends JpaRepository<AlarmEntity, Long> {
    List<AlarmEntity> findAllByIdInOrderByCreatedAtDesc(List<Long> userId);
}
