import { TestBed, inject } from '@angular/core/testing';
import { ToDoService } from './todo.service';
import { checkAndUpdateBinding } from '@angular/core/src/view/util';
import { TodoListComponent } from '../../todo-list/todo-list.component';
import { ToDo } from '../../ToDo';

describe('TodoService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ToDoService]
    });
  });

  it('should be created', inject([ToDoService], (service: ToDoService) => {
    expect(service).toBeTruthy();
  }));
});
