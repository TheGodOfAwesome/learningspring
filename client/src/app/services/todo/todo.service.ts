import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class ToDoService {
	public url: string = 'http://localhost:8080/api/todos/';
  
	constructor(private httpClient: HttpClient) {}

	getAll(): Observable<any> {
		return this.httpClient.get(this.url);
	}

	refreshComponent(): Observable<any> {
		return this.httpClient.get(this.url);
	}

	addOne(value: any): Observable<any> {
		return this.httpClient.post(this.url + 'add/', value);
	}

	deleteOne(values: any) : Observable<any> {
		return this.httpClient.post(this.url + 'delete/', values);
	}

	updateOne(value: any) : Observable<any> {
		return this.httpClient.post(this.url + 'update/', value);
	}

}
