package com.hakareem.Review.repository;

import com.hakareem.Review.domain.Assignment;
import com.hakareem.Review.domain.User;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    Assignment findByUserId(Long userId);
    List<Assignment> findAllByUserId(Long userId);
    Set<Assignment> findByUser(User user);
    Assignment findByIdAndUser(Long id, User user);
    Optional<Assignment> findById(Long assignmentId);
}
