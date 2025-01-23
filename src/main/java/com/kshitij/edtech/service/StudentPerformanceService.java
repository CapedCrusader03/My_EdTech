package com.kshitij.edtech.service;

import com.kshitij.edtech.model.StudentPerformance;
import com.kshitij.edtech.repository.StudentPerformanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentPerformanceService {
    @Autowired
    private StudentPerformanceRepository repository;

    public StudentPerformance savePerformance(StudentPerformance performance) {
        return repository.save(performance);
    }

    public List<StudentPerformance> getPerformanceByStudentId(Long studentId) {
        return repository.findByStudentId(studentId);
    }
}
