package com.example.hackathonbe.paper.repository;

import com.example.hackathonbe.paper.entity.PaperEntity;
import com.example.hackathonbe.paper.entity.enums.VisibilityScope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaperRepository extends JpaRepository<PaperEntity, Long> {
    List<PaperEntity> findAllByOwner(Long userId);

    List<PaperEntity> findAllByVisibilityScope(VisibilityScope visibilityScope);

    List<PaperEntity> findAllByOwnerIn(List<Long> userIdList);
}
