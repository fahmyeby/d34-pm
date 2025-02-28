import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { StudentserviceService } from '../service/studentservice.service';

@Component({
  selector: 'app-studentform',
  standalone: false,
  templateUrl: './studentform.component.html',
  styleUrl: './studentform.component.css',
})
export class StudentformComponent implements OnInit {
  studentForm!: FormGroup;
  courses: any[] = [];

  constructor(
    private fb: FormBuilder,
    private studentService: StudentserviceService,
    private router: Router
  ) {}
  ngOnInit(): void {
    this.studentForm = this.fb.group({
      name: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      courseId: ['', [Validators.required]],
    });
    this.studentService.getCourses().subscribe(data => {
      this.courses = data;
    })
  }

  submitForm(): void {
    if (this.studentForm.valid){
      this.studentService.enrollStudent(this.studentForm.value).subscribe(() => {
        alert('Enrolled successfully');
        this.router.navigate(['/course', this.studentForm.value.courseId]) // navigate to course details
      })
    }
  }
}
