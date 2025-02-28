package com.example.d35_pm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.d35_pm.repo.StudentRepo;

@SpringBootApplication
public class D35PmApplication implements CommandLineRunner {
	@Autowired
	private StudentRepo repo;

	public static void main(String[] args) {
		SpringApplication.run(D35PmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repo.addSampleCourses();
		System.out.println("Courses added");
	}

}
