import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http'
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
	
	constructor(private toDoService: ToDoService, private httpClient: HttpClient) { }
	
	ngOnInit() {

		this.toDoService.getAll().subscribe(
			data => {
				this.toDos = data;
			},
			error => console.log(error)
		)
	}

	onSubmit(value: any){
		console.log(value);
		this.httpClient.post("http://localhost:8080/api/todos/add/", value)
        .subscribe(
            (data:any) => {
                console.log(data)
            }
		)
		window.location.reload();
    }

	onSelect(toDo: ToDo): void{
		this.selectedToDo = toDo;
	}

}
