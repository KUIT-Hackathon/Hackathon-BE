package com.example.hackathonbe.skeleton.repository;

import com.example.hackathonbe.skeleton.entity.Skeleton;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/* DB 연동 */

@Repository
public interface SkeletonRepository extends JpaRepository<Skeleton, Long> {
}
