package com.hakareem.Review.controller;

import com.hakareem.Review.domain.Assignment;
import com.hakareem.Review.domain.User;
import com.hakareem.Review.service.AssignmentService;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {

    private static final Logger logger = LoggerFactory.getLogger(AssignmentController.class);

    private final AssignmentService assignmentService;

    @Autowired
    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @PostMapping("")
    public ResponseEntity<Assignment> createAssignment(@AuthenticationPrincipal User user) {
        Assignment newAssignment = assignmentService.save(user);
        logger.info("Assignment created for user {}", user.getUsername());
        return ResponseEntity.ok(newAssignment);
    }


    @GetMapping("") 
    public ResponseEntity<?> getAssignments(@AuthenticationPrincipal User user) {
        Set<Assignment> assignments = assignmentService.getAssignment(user);
        logger.info("Assignments retrieved for user {}", user.getUsername());
        return ResponseEntity.ok(assignments);
    }

    @GetMapping("{assignmentId}")
    public ResponseEntity<?> getAssignmentById(@PathVariable Long assignmentId, @AuthenticationPrincipal User user) {
        Optional<Assignment> assignment = assignmentService.findById(assignmentId);
        if (assignment.isPresent()) {
            logger.info("Assignment retrieved for user {}", user.getUsername());
            return ResponseEntity.ok(assignment);
        } else {
            logger.error("Assignment not found for user {}", user.getUsername());
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{assignmentId}")
    public ResponseEntity<?> updateAssignment(@PathVariable Long assignmentId, @AuthenticationPrincipal User user, @RequestBody Assignment assignment) {
        Assignment updatedAssignment = assignmentService.save(assignment);
        logger.info("Assignment updated for user {}", user.getUsername());
        return ResponseEntity.ok(updatedAssignment);
    }
}
