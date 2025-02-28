package com.example.d35_pm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.d35_pm.service.StudentService;

@RestController
@RequestMapping("/api/students")
@CrossOrigin("*")
public class StudentController {
    @Autowired
    private StudentService svc;

    @PostMapping("/enroll")
    public ResponseEntity<?> enrollStudent(@RequestBody Map<String, String> request){
        String name = request.get("name");
        String email = request.get("email");
        int courseId = Integer.parseInt(request.get("courseId"));

        svc.enrollStudent(name, email, courseId);
        return ResponseEntity.ok("Student enrolled");
    }

    @GetMapping("/courses")
    public ResponseEntity<List<Map<String, Object>>> getCourses() {
        return ResponseEntity.ok(svc.getCourses());
    }
}
