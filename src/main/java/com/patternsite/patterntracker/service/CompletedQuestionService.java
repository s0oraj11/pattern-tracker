package com.patternsite.patterntracker.service;

import com.patternsite.patterntracker.model.CompletedQuestion;
import com.patternsite.patterntracker.repository.CompletedQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompletedQuestionService {
    @Autowired
    private CompletedQuestionRepository completedQuestionRepository;
    
    public List<Long> getCompletedQuestionIds(String userId) {
        return completedQuestionRepository.findByUserId(userId)
            .stream()
            .map(CompletedQuestion::getQuestionId)
            .collect(Collectors.toList());
    }
    
    @Transactional
    public void toggleQuestionCompletion(String userId, Long questionId) {
        if (completedQuestionRepository.existsByUserIdAndQuestionId(userId, questionId)) {
            completedQuestionRepository.deleteByUserIdAndQuestionId(userId, questionId);
        } else {
            CompletedQuestion completedQuestion = new CompletedQuestion();
            completedQuestion.setUserId(userId);
            completedQuestion.setQuestionId(questionId);
            completedQuestionRepository.save(completedQuestion);
        }
    }
}
