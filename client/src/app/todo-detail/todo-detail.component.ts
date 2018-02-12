import { Component, OnInit, Input } from '@angular/core';
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

    constructor() { }
    
    ngOnInit() {

    }
}