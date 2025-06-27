package com.example.hackathonbe.skeleton.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/* DB 정의. ddl-auto 이므로 db 별도 수정 불필요. */

@Entity
@Table(name = "skeleton_data")
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class Skeleton {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(nullable = false)
    private String name;
}
