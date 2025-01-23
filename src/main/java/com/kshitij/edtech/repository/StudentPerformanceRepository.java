package com.kshitij.edtech.repository;

import com.kshitij.edtech.model.StudentPerformance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentPerformanceRepository extends JpaRepository<StudentPerformance, Long> {
    List<StudentPerformance> findByStudentId(Long studentId);
}
