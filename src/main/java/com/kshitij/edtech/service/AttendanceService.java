package com.kshitij.edtech.service;

import com.kshitij.edtech.model.Attendance;
import com.kshitij.edtech.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AttendanceService {
    @Autowired
    private AttendanceRepository repository;

    public Attendance saveAttendance(Attendance attendance) {
        return repository.save(attendance);
    }

    public List<Attendance> getAttendanceByStudentId(Long studentId) {
        return repository.findByStudentId(studentId);
    }

    public List<Attendance> getAttendanceByStudentIdAndDateRange(Long studentId, LocalDate startDate, LocalDate endDate) {
        return repository.findByStudentIdAndDateBetween(studentId, startDate, endDate);
    }
}
