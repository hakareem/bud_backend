package com.hakareem.Review.domain;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private String branch;
    private String codeReviewUrl;
    private String githubUrl;
    @ManyToOne(optional = false)
    private User user;

}
