package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.services.UserService;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
;

@RestController
@RequestMapping("api/users/")
@Slf4j
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

    @GetMapping(value = "add/")
    public Iterable<User> addUsers(){
        userService.addUsers();
        log.info("added users");
        return userService.getAllUsers();
    }

    @GetMapping(value = "{id}")
    public User getUserById(@PathVariable("id") long id){
        log.info("getting user by id");
        return userService.getUserById(id);
    }

    @PostMapping(value = "add/")
    public String addUser(@RequestBody UserDto userDto){
        log.info("adding a user");
        return userService.addUser(userDto.getId(), userDto.getName(), userDto.getEmail(), userDto.getPassword());
    }

    @PostMapping(value = "find/")
    public User findUserByEmailAndPassword(@RequestBody UserDto userDto){
        log.info("finding if user exists");
        return userService.userExistsByEmailAndPassword(userDto.getEmail(), userDto.getPassword());
    }

    @DeleteMapping(value ="{id}")
    public Boolean deleteUserId(@PathVariable("id") long id) {
        log.info("deleting user by id");
        return userService.deleteUser(id);
    }

}
