package com.example.hackathonbe.paper.repository;

import com.example.hackathonbe.paper.entity.enums.PaperEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaperRepository extends JpaRepository<PaperEntity, Long> {
}
