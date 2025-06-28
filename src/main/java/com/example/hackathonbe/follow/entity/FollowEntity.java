package com.example.hackathonbe.follow.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class FollowEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint", nullable = false)
    private Long id;

    @Column(columnDefinition = "bigint", nullable = false)
    private Long fromUserId;

    @Column(columnDefinition = "bigint", nullable = false)
    private Long toUserId;

    @Column(columnDefinition = "timestamp", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    private static FollowEntity create(Long from_user_id, Long to_user_id) {
        FollowEntity followEntity = new FollowEntity();
        followEntity.fromUserId = from_user_id;
        followEntity.toUserId = to_user_id;

        return followEntity;
    }
}
