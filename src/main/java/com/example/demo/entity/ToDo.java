package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class ToDo implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    private String toDoName;
    private long userId;
    private String description;
    private String dateTime;
    private String priority;
    private String status;

    public ToDo(long id, String toDoName, long userId, String description, String dateTime, String status, String priority) {
        this.id = id;
        this.toDoName = toDoName;
        this.userId = userId;
        this.description = description;
        this.dateTime = dateTime;
        this.priority = priority;
        this.status = status;
    }

    public ToDo(){}
}
