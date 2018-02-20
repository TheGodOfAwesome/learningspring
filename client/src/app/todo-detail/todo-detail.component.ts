import { Component, OnInit, Input } from '@angular/core';
import { Http, Response, Headers } from '@angular/http';
import { HttpClient } from '@angular/common/http';
import { NgModel } from '@angular/forms';
import { ToDo } from '../ToDo';
import { ToDoService } from '../services'
import { TodoListComponent } from '../todo-list/todo-list.component';

@Component({
    selector: 'app-todo-detail',
    templateUrl: './todo-detail.component.html',
    styleUrls: ['./todo-detail.component.css']

})

export class TodoDetailComponent implements OnInit{
    @Input() toDo: ToDo;
    toDos: Array<any>;

    constructor(private httpClient: HttpClient, private toDoService: ToDoService) { }

    deleteToDo(values: any){
        this.toDoService.deleteOne(values).subscribe(
            (response:any) => {
                console.log(response);
				this.toDos = response;
            }
        )
    }

    onSubmit(value: any){
        console.log(value);
        this.toDoService.updateOne(value).subscribe(
            (response:any) => {
                console.log(response);
				this.toDos = response;
            } 
        )
    }
    
    ngOnInit() {
        
    }
}