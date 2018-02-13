package com.example.demo.repository;

import com.example.demo.entity.ToDo;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<ToDo, Long> {

    void deleteById(Long id);
    Iterable<ToDo> findAllByStatus(String status);

}
