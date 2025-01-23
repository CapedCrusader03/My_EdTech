package com.kshitij.edtech.controller;

import com.kshitij.edtech.model.Attendance;
import com.kshitij.edtech.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {
    @Autowired
    private AttendanceService service;

    @PostMapping
    public ResponseEntity<Attendance> addAttendance(@RequestBody Attendance attendance) {
        return ResponseEntity.ok(service.saveAttendance(attendance));
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<List<Attendance>> getAttendance(@PathVariable("studentId") Long studentId) {
        return ResponseEntity.ok(service.getAttendanceByStudentId(studentId));
    }

    @GetMapping("/{studentId}/range")
    public ResponseEntity<List<Attendance>> getAttendanceByDateRange(
            @PathVariable("studentId") Long studentId,
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate) {
    	System.out.println(studentId + startDate + endDate);
        return ResponseEntity.ok(service.getAttendanceByStudentIdAndDateRange(
                studentId, LocalDate.parse(startDate), LocalDate.parse(endDate)
        ));
    }
}
