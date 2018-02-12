import { Component, OnInit } from '@angular/core';
import { ToDoService } from '../shared';
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
	
	constructor(private toDoService: ToDoService) { }
	
	ngOnInit() {

		this.toDoService.getAll().subscribe(
			data => {
				this.toDos = data;
			},
			error => console.log(error)
		)
	}

	onSelect(toDo: ToDo): void{
		this.selectedToDo = toDo;
	}

}
