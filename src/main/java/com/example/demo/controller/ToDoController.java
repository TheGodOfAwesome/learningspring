package com.example.demo.controller;


import com.example.demo.dto.ToDoDto;
import com.example.demo.entity.ToDo;
import com.example.demo.services.ToDoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/todos")
@Slf4j
public class ToDoController {

    private final ToDoService toDoService;

    @Autowired
    public ToDoController(ToDoService toDoService){
        this.toDoService = toDoService;
    }

    @GetMapping(value = "")
    @CrossOrigin(origins = "http://localhost:4200")
    public Iterable<ToDo> getAllToDos(){
        log.info("getting all todos");
        return toDoService.getAllToDos();
    }

    @GetMapping(value = "/{id}")
    public ToDo getToDoById(long id){
        log.info("getting todo by id");
        return toDoService.getToDoById(id);
    }

    @PostMapping(value = "/add")
    public Iterable<ToDo> addToDos(@RequestBody ToDoDto toDo) {
        toDoService.addToDo(toDo);
        log.info("adding todo {}",toDo.toString());
        return toDoService.getAllToDos();
    }

    @DeleteMapping(value = "/{id}")
    public Iterable<ToDo> deleteToDoById(long id){
        return toDoService.deleteToDoById(id);
    }

}
