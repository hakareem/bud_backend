package com.hakareem.Review.service;

import com.hakareem.Review.domain.Assignment;
import com.hakareem.Review.domain.User;
import com.hakareem.Review.repository.AssignmentRepository;
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
}
