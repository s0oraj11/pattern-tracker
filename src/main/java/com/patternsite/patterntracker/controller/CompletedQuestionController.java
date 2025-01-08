package com.patternsite.patterntracker.controller;

import com.patternsite.patterntracker.model.CompletedQuestion;
import com.patternsite.patterntracker.service.CompletedQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/completed-questions")
public class CompletedQuestionController {
    @Autowired
    private CompletedQuestionService completedQuestionService;
    
    @GetMapping
    public List<Long> getCompletedQuestions(@AuthenticationPrincipal OAuth2User principal) {
        String userId = principal.getAttribute("sub");  // Google OAuth user ID
        return completedQuestionService.getCompletedQuestionIds(userId);
    }
    
    @PostMapping("/{questionId}")
    public ResponseEntity<?> toggleQuestionCompletion(
            @PathVariable Long questionId,
            @AuthenticationPrincipal OAuth2User principal) {
        String userId = principal.getAttribute("sub");
        completedQuestionService.toggleQuestionCompletion(userId, questionId);
        return ResponseEntity.ok().build();
    }
}
