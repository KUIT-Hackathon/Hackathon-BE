package com.example.hackathonbe.follow.repository;

import com.example.hackathonbe.follow.entity.FollowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FollowRepository extends JpaRepository<FollowEntity, Long> {
    List<FollowEntity> findAllByFromUserId(Long id);

    boolean existsByFromUserIdAndToUserId(Long fromUserId, Long toUserId);

}
