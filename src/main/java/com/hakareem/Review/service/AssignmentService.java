package com.hakareem.Review.service;

import com.hakareem.Review.domain.Assignment;
import com.hakareem.Review.domain.User;
import com.hakareem.Review.repository.AssignmentRepository;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepository;

    public Assignment save (User user) {
        Assignment assignment = new Assignment();
        assignment.setStatus("Needs to be submitted");
        assignment.setUser(user);
        return assignmentRepository.save(assignment);
    };

    public List<Assignment> getAssignments(User user) {
        return assignmentRepository.findAllByUserId(user.getId());
    }

    public Set<Assignment> getAssignment(User user) {
        return assignmentRepository.findByUser(user);
    }

    public Assignment getAssignmentByIdAndUser(Long id, User user) {
        return assignmentRepository.findByIdAndUser(id, user);
    }

   public Optional<Assignment> findById(Long assignmentId) {
        return assignmentRepository.findById(assignmentId);
    }

    public Assignment save(Assignment assignment) {
       return assignmentRepository.save(assignment);
    }
}
