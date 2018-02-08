package com.example.demo.services;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    @Autowired /*UserService Constructor used to instantiate multiple objects*/
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
//        return userDao.getAllUsers();
    }

    public User getUserById(int id){
        return userRepository.findOne(id);
//        return userDao.getUserById(id);
    }

    public User getUserByName(String name) {
        return userRepository.findByName(name);
    }

    public User getUserByNameAndEmail(String name, String email) {
        return userRepository.findByNameAndEmail(name,email);
    }

    public Boolean deleteUser(int id) {
        User user = userRepository.findOne(id);

        if (user != null) {
            userRepository.delete(user);
            return true;
        }

        log.warn("Stop fooling around, user with id {} doesn't exist",id);
        return false;



    }


}
