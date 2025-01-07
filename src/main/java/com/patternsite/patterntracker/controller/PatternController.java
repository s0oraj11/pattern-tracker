package com.patternsite.patterntracker.controller;

import com.patternsite.patterntracker.model.Pattern;
import com.patternsite.patterntracker.service.PatternService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patterns")
public class PatternController {
    @Autowired
    private PatternService patternService;
    
    @GetMapping
    public List<Pattern> getAllPatterns() {
        return patternService.getAllPatterns();
    }
    
    @GetMapping("/{id}")
    public Pattern getPatternById(@PathVariable Long id) {
        return patternService.getPatternById(id);
    }
    
    @PostMapping
    public Pattern createPattern(@RequestBody Pattern pattern) {
        return patternService.createPattern(pattern);
    }
    
    @PutMapping("/{id}")
    public Pattern updatePattern(@PathVariable Long id, @RequestBody Pattern pattern) {
        return patternService.updatePattern(id, pattern);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePattern(@PathVariable Long id) {
        patternService.deletePattern(id);
        return ResponseEntity.ok().build();
    }
    
    @PostMapping("/{id}/practice")
    public Pattern recordPractice(@PathVariable Long id) {
        return patternService.recordPractice(id);
    }
}