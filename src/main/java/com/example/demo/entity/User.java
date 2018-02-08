package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class User {

    private int id;
    private String name;
    private String email;
    private String password;

    /* non-nullary constructor */
    public User(int id,  String name, String email, String password){
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(){}

}
