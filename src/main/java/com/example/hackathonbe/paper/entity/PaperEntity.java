package com.example.hackathonbe.paper.entity;

import com.example.hackathonbe.paper.entity.enums.Category;
import com.example.hackathonbe.paper.entity.enums.VisibilityScope;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(
        indexes = @Index(name = "idx_owner", columnList = "owner") // 페이퍼 리스트 조회할 때 owner 기준으로 가져오기 때문에 인덱스 생성
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PaperEntity {
    @Id
    @Column(columnDefinition = "varchar(36)", nullable = false)
    private String uuid;

    @Column(columnDefinition = "bigint", nullable = true)
    private Long owner;

    @Column(columnDefinition = "timestamp", nullable = false)
    private LocalDateTime publishDate;

    @Column(columnDefinition = "varchar(20)", nullable = false)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private VisibilityScope visibilityScope;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    @Column(columnDefinition = "timestamp", nullable = false)
    private LocalDateTime createdAt;

    public static PaperEntity create(Long owner, LocalDateTime publish_date, String title, VisibilityScope visibilityScope, Category category) {
        PaperEntity paperEntity = new PaperEntity();
        paperEntity.uuid = UUID.randomUUID().toString();
        paperEntity.owner = owner;
        paperEntity.publishDate = publish_date;
        paperEntity.title = title;
        paperEntity.visibilityScope = visibilityScope;
        paperEntity.category = category;
        paperEntity.createdAt = LocalDateTime.now();

        return paperEntity;
    }
}
