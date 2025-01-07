package com.patternsite.patterntracker.service;

import com.patternsite.patterntracker.model.Pattern;
import com.patternsite.patterntracker.repository.PatternRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PatternService {
    @Autowired
    private PatternRepository patternRepository;
    
    public List<Pattern> getAllPatterns() {
        return patternRepository.findAll();
    }
    
    public Pattern getPatternById(Long id) {
        return patternRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Pattern not found"));
    }
    
    public Pattern createPattern(Pattern pattern) {
        pattern.setCreatedAt(LocalDateTime.now());
        pattern.setUpdatedAt(LocalDateTime.now());
        return patternRepository.save(pattern);
    }
    
    public Pattern updatePattern(Long id, Pattern patternDetails) {
        Pattern pattern = getPatternById(id);
        pattern.setName(patternDetails.getName());
        pattern.setCategory(patternDetails.getCategory());
        pattern.setDescription(patternDetails.getDescription());
        pattern.setDifficulty(patternDetails.getDifficulty());
        pattern.setUpdatedAt(LocalDateTime.now());
        return patternRepository.save(pattern);
    }
    
    public void deletePattern(Long id) {
        Pattern pattern = getPatternById(id);
        patternRepository.delete(pattern);
    }
    
    public Pattern recordPractice(Long id) {
        Pattern pattern = getPatternById(id);
        pattern.setTimesPracticed(pattern.getTimesPracticed() + 1);
        pattern.setLastPracticed(LocalDateTime.now());
        pattern.setUpdatedAt(LocalDateTime.now());
        return patternRepository.save(pattern);
    }
}