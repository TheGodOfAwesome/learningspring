package com.example.demo.repository;

import com.example.demo.entity.ToDo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<ToDo, Long> {

    void deleteById(Long id);
    Iterable<ToDo> findAllByStatus(String status);

    //@Modifying(clearAutomatically = true)
    //@Query("UPDATE ToDo SET ToDo.toDoName =:toDo.toDoName, ToDo. WHERE id = toDo.id")

    /*@Modifying(clearAutomatically = true)
    @Query("update RssFeedEntry feedEntry set feedEntry.read =:isRead where feedEntry.id =:entryId")
    void markEntryAsRead(@Param("entryId") Long rssFeedEntryId, @Param("isRead") boolean isRead);*/

}
