package com.example.hackathonbe.paper.entity.enums;

import com.example.hackathonbe.paper.entity.Category;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PaperEntity {
    @Id
    @Column(columnDefinition = "varchar(36)", nullable = false)
    private String uuid;

    @Column(columnDefinition = "bigint", nullable = true)
    private Long owner;

    @Column(columnDefinition = "timestamp", nullable = false)
    private LocalDateTime publish_date;

    @Column(columnDefinition = "varchar(20)", nullable = false)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private VisibilityScope visibilityScope;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    @Column(columnDefinition = "timestamp", nullable = false)
    private LocalDateTime created_at;

    public static PaperEntity create(Long owner, LocalDateTime publish_date, String title, VisibilityScope visibilityScope, Category category) {
        PaperEntity paperEntity = new PaperEntity();
        paperEntity.uuid = UUID.randomUUID().toString();
        paperEntity.owner = owner;
        paperEntity.publish_date = publish_date;
        paperEntity.title = title;
        paperEntity.visibilityScope = visibilityScope;
        paperEntity.category = category;
        paperEntity.created_at = LocalDateTime.now();

        return paperEntity;
    }
}
