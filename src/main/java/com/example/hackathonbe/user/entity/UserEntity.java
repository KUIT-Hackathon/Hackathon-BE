package com.example.hackathonbe.user.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "user")
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(columnDefinition = "VARCHAR(8)", nullable = false)
    private String name;

    @NonNull
    @Column(columnDefinition = "VARCHAR(20)", nullable = false, unique = true)
    private String loginId;

    @NonNull
    @Column(columnDefinition = "VARCHAR(20)", nullable = false)
    private String password;

    @Column(columnDefinition = "TIMESTAMP", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Setter
    @Column(columnDefinition = "TIMESTAMP", nullable = true)
    private LocalDateTime lastCheckedAt;

    public void setLastCheckedAt(LocalDateTime now) {
    }
}
