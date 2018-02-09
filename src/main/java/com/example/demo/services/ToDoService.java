package com.example.demo.services;

import com.example.demo.entity.ToDo;
import com.example.demo.repository.ToDoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ToDoService {

    private final ToDoRepository toDoRepository;

    @Autowired
    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public ToDo testToDo(){
        return toDoRepository.save(new ToDo(1, "Finish Todo App", 1, "Finish Todo App By End of Weekend", "12/02/2018", "In Progress", "High"));
    }

    public ToDo addToDo(long id, String toDoName, long userId, String description, String dateTime, String status, String priority){
        return toDoRepository.save(new ToDo(id, toDoName, userId, description, dateTime, status, priority));
    }

    public Iterable<ToDo> getAllToDos (){
        return toDoRepository.findAll();
    }

    public Iterable<ToDo> getToDoByUserId(long userId){
        return toDoRepository.findTodoByUserId(userId);
    }

    public Iterable<ToDo> getToDoByUserAndStatus(long userId, String status){
        return toDoRepository.findByUserIdAndStatus(userId, status);
    }

    public Iterable<ToDo> getToDoByUserAndPriority(long userId, String priority){
        return toDoRepository.findByUserIdAndPriority(userId, priority);
    }

    public Iterable<ToDo> getToDoByUserPriorityAndStatus(long userId, String priority, String status){
        return toDoRepository.findByUserIdAndPriorityAndStatus(userId, priority, status);
    }

    public ToDo getToDoById(long id){
        return toDoRepository.findOne(id);
    }

    public Iterable<ToDo> getToDoByIdAndStatus(long userId, String status){
        return toDoRepository.findByUserIdAndStatus(userId, status);
    }

    public ToDo getToDoByUserAndToDoName(long userId, String toDoName){
        return toDoRepository.findByUserIdAndToDoName(userId, toDoName);
    }

    public Iterable<ToDo> getToDoByUserAndDateTime(long userId, String dateTime){
        return toDoRepository.findByUserIdAndDateTime(userId, dateTime);
    }

    public Iterable<ToDo> deleteToDoById(long id){
        toDoRepository.delete(id);
        return getAllToDos();
    }

}
