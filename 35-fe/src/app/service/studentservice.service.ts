import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StudentserviceService {
  private baseUrl = 'http://localhost:8080/api/students';
  constructor(private httpClient: HttpClient) { }

  enrollStudent(student: any): Observable<any> {
    return this.httpClient.post(`${this.baseUrl}/enroll`, student);
  }

  getCourses(): Observable<any> {
    return this.httpClient.get(`${this.baseUrl}/courses`);
  }
}
