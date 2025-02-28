package com.example.d35_pm.repo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void addSampleCourses(){
        String sql = "insert into courses (course_name, description) values (?, ?)";
        jdbcTemplate.update(sql, "Mathematics", "Basic algebra and geometry.");
        jdbcTemplate.update(sql, "Science", "Physics and Chemistry basics.");
        jdbcTemplate.update(sql, "History", "World history and civilizations.");
        jdbcTemplate.update(sql, "Computer Science", "Introduction to programming.");
    }

    @Transactional
    public void saveStudentAndCourse(String name, String email, Integer courseId) {
        String sql = "insert into students (name, email) values (?, ?)";
        jdbcTemplate.update(sql, name, email);
        int studentId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        String insertStudentCourse = "insert into student_courses (student_id, course_id) values (?, ?)";
        jdbcTemplate.update(insertStudentCourse, studentId, courseId);
    }

    public List<Map<String, Object>> getCourses() {
        return jdbcTemplate.queryForList("select * from courses");
    }
}
