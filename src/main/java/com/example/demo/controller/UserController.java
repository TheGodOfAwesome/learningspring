package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.services.UserService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("api/users/")
@Log
public class UserController {

    private final UserService userService;

    @Autowired /*UserController Constructor used to instantiate multiple objects using autowired annotation*/
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "")
    public Iterable<User> getAllUsers(){
        log.info("getting all users");
        return userService.getAllUsers();
    }

    @GetMapping(value = "/id/{id}")
    public User getUserById(@PathVariable("id") int id){
        log.info("getting user by id");
        return userService.getUserById(id);
    }

    @DeleteMapping(value ="/id/{id}")
    public Boolean deleteUserId(@PathVariable("id") int id) {
        return userService.deleteUser(id);
    }

}
