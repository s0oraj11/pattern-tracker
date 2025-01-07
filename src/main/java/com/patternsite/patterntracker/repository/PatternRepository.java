package com.patternsite.patterntracker.repository;

import com.patternsite.patterntracker.model.Pattern;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PatternRepository extends JpaRepository<Pattern, Long> {
    List<Pattern> findByCategory(String category);
    List<Pattern> findByDifficulty(String difficulty);
}