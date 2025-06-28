package com.example.hackathonbe.message.repository;

import com.example.hackathonbe.message.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, Long> {
    List<MessageEntity> findAllByUuid(String uuid);

    long countAllByUuid(String uuid);
}
