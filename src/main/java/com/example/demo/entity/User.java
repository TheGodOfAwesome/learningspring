package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class User implements Serializable{

    @Id
    @GeneratedValue
    @Column(unique=true)
    private long id;

    private String name;

    @Column(unique=true)
    private String email;

    private String password;

    public User(long id,  String name, String email, String password){
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(){}

}
