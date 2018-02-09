package com.example.demo.repository;

import com.example.demo.entity.ToDo;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<ToDo, Long> {

    Iterable<ToDo> findTodoByUserId(Long userId);
    Iterable<ToDo> findByUserIdAndStatus(Long userId, String status);
    Iterable<ToDo> findByUserIdAndPriority(Long userId, String priority);
    Iterable<ToDo> findByUserIdAndPriorityAndStatus(Long userId, String priority, String status);
    ToDo findByUserIdAndToDoName(long userId, String toDoName);
    Iterable<ToDo> findByUserIdAndDateTime(Long userId, String dateTime);
    void deleteById(long id);

}
