import { Component, OnInit, Input } from '@angular/core';
import {Http, Response, Headers} from '@angular/http';
import { NgModel } from '@angular/forms';
import { ToDo } from '../ToDo';

@Component({
    selector: 'app-todo-detail',
    templateUrl: './todo-detail.component.html',
    styleUrls: ['./todo-detail.component.css']

})
export class TodoDetailComponent implements
OnInit{
    @Input() toDo: ToDo;

    constructor(private http: Http) { }

    updateToDo = function(ToDo){
        this.toDo = {
            "id": ToDo.id,
            "toDoName": ToDo.toDoName,
            "description": ToDo.description,
            "dateTime": ToDo.dateTime,
            "priority": ToDo.priority,
            "status": ToDo.status
        }
        //this.http.post("http://localhost:4200/api/todos/update/", this.toDo.subscribe)
    }
    
    ngOnInit() {

    }
}