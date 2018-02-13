import { Component, OnInit, Input } from '@angular/core';
import { Http, Response, Headers } from '@angular/http';
import { HttpClient } from '@angular/common/http';
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

    constructor(private httpClient: HttpClient) { }

    deleteToDo(values: any){
        console.log(values);
        this.httpClient.post("http://localhost:8080/api/todos/delete/", values)
        .subscribe(
            (data:any) => {
                console.log(data)
            }
        )
        window.location.reload();
    }

    onSubmit(value: any){
        console.log(value);
        this.httpClient.post("http://localhost:8080/api/todos/update/", value)
        .subscribe(
            (data:any) => {
                console.log(data)
            }
        )
        window.location.reload();
    }
    
    ngOnInit() {

    }
}