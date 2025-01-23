package com.kshitij.edtech.controller;

import com.kshitij.edtech.model.StudentPerformance;
import com.kshitij.edtech.service.StudentPerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/performance")
public class StudentPerformanceController {
    @Autowired
    private StudentPerformanceService service;

    @PostMapping
    public ResponseEntity<StudentPerformance> addPerformance(@RequestBody StudentPerformance performance) {
        return ResponseEntity.ok(service.savePerformance(performance));
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<List<StudentPerformance>> getPerformance(@PathVariable("studentId") Long studentId) {
        return ResponseEntity.ok(service.getPerformanceByStudentId(studentId));
    }
}
