package com.patternsite.patterntracker.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "completed_questions",
       uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "question_id"}))
public class CompletedQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "user_id", nullable = false)
    private String userId;  // Google OAuth user ID
    
    @Column(name = "question_id", nullable = false)
    private Long questionId;
    
    @Column(name = "completed_at")
    private LocalDateTime completedAt = LocalDateTime.now();
}