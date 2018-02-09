package com.example.demo.dto;

import lombok.Data;

@Data
public class ToDoDto {

    private long id;
    private String toDoName;
    private long userId;
    private String description;
    private String dateTime;
    private String priority;
    private String status;

}
