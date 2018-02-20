import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { ToDoService } from '../services';
import { ToDo } from '../ToDo';

@Component({
	selector: 'app-todo-list',
	templateUrl: './todo-list.component.html',
	styleUrls: ['./todo-list.component.css'],
	providers: [ToDoService]
})

export class TodoListComponent implements OnInit {
	toDos: Array<any>;
	selectedToDo: ToDo;
	interval: any;
	
	constructor(private toDoService: ToDoService, private httpClient: HttpClient) { }
	
	refreshDataList(){
		console.log("refreshing list")
		this.toDoService
			.getAll()
			.subscribe(
				data => {
					this.toDos = data;
				},
			error => console.log(error)
			) 
	}

	ngOnInit() {
		this.interval = setInterval(() => { 
			this.refreshDataList(); 
		}, 500);
	}

	onSubmit(value: any){
		console.log(value);
		this.toDoService
			.addOne(value)
			.subscribe(
				response => {
					console.log(response);
					this.toDos = response;
				},
				error => console.log(error)
			)
	}

	onSelect(toDo: ToDo): void{
		this.selectedToDo = toDo;
	}

}
