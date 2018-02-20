import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { HttpModule } from '@angular/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { TodoListComponent } from './todo-list/todo-list.component';
import { TodoDetailComponent } from './todo-detail/todo-detail.component';
import { AlertComponent } from './alert/alert.component';

const routes: Routes = [
  {path:'', pathMatch: 'full', redirectTo: 'home' },
  {path:'home', component: HomeComponent},
  {path:'login', component: LoginComponent}
];

@NgModule({
	declarations: [
    AppComponent,
    TodoListComponent,
    TodoDetailComponent,
    AlertComponent,
    HomeComponent,
    LoginComponent
  ],
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule, 
    HttpClientModule,
    HttpModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
