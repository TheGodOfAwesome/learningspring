package com.example.demo.repository;

import com.example.demo.entity.ToDo;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<ToDo, Long> {

    Iterable<ToDo> findTodoByUserId(long userId);
    Iterable<ToDo> findByUserIdAndStatus(long userId, String status);
    Iterable<ToDo> findByUserIdAndPriority(long userId, String priority);
    Iterable<ToDo> findByUserIdAndPriorityAndStatus(long userId, String priority, String status);
    ToDo findByUserIdAndToDoName(long userId, String toDoName);
    Iterable<ToDo> findByUserIdAndDateTime(long userId, String dateTime);
    void deleteByIdAndUserId(long id, long userId);
    void deleteById(long id);

}
