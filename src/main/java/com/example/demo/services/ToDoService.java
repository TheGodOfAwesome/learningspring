package com.example.demo.services;

import com.example.demo.dto.ToDoDto;
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

    public ToDo addToDo(ToDoDto toDo){
        return toDoRepository.save(new ToDo(toDo.getId(), toDo.getToDoName(), toDo.getUserId() , toDo.getDescription(), toDo.getDateTime(), toDo.getStatus(), toDo.getPriority()));
    }

    public Iterable<ToDo> getAllToDos (){
        return toDoRepository.findAll();
    }

    public ToDo getToDoById(long id){
        return toDoRepository.findOne(id);
    }

    public ToDo updateToDo(ToDoDto toDo){
        toDoRepository.deleteById(toDo.getId());
        return toDoRepository.save(new ToDo(toDo.getId(), toDo.getToDoName(), toDo.getUserId() , toDo.getDescription(), toDo.getDateTime(), toDo.getStatus(), toDo.getPriority()));
    }

    public void deleteToDoById(Long id){
        toDoRepository.deleteById(id);
    }

    public Iterable<ToDo> getAllByStatus(String status) {
        return toDoRepository.findAllByStatus(status);
    }

}
