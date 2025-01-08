package com.patternsite.patterntracker.repository;

import com.patternsite.patterntracker.model.CompletedQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CompletedQuestionRepository extends JpaRepository<CompletedQuestion, Long> {
    List<CompletedQuestion> findByUserId(String userId);
    boolean existsByUserIdAndQuestionId(String userId, Long questionId);
    void deleteByUserIdAndQuestionId(String userId, Long questionId);
}