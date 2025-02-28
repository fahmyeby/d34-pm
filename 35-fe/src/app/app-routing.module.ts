import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StudentformComponent } from './component/studentform.component';
import { CoursedetailsComponent } from './component/coursedetails.component';

const routes: Routes = [
  {path: 'enroll', component: StudentformComponent},
  {path: 'course/:id', component: CoursedetailsComponent},
  {path: '', redirectTo: 'enroll', pathMatch: 'full'},
  {path: '**', redirectTo:'enroll'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
