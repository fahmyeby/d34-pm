import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { StudentserviceService } from '../service/studentservice.service';

@Component({
  selector: 'app-coursedetails',
  standalone: false,
  templateUrl: './coursedetails.component.html',
  styleUrl: './coursedetails.component.css',
})
export class CoursedetailsComponent implements OnInit {
  course: any;
  constructor(
    private route: ActivatedRoute,
    private studentService: StudentserviceService
  ) {}

  ngOnInit(): void {
    const courseId = this.route.snapshot.params['id'];
    this.studentService.getCourses().subscribe(courses => {
      this.course = courses.find((c: { id: any; }) => c.id == courseId);
    });
  }
}
