package com.example.d35_pm.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.d35_pm.repo.StudentRepo;

@Service
public class StudentService {
    @Autowired
    private StudentRepo repo;

    @Transactional
    public void enrollStudent(String name, String email, int courseId){
        repo.saveStudentAndCourse(name, email, courseId);
    }

    public List<Map<String, Object>> getCourses() {
        return repo.getCourses();
    }
}
