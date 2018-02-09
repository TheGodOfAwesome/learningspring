package com.example.demo.services;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public String addUsers(){
        userRepository.save(new User(1,  "Kuzivakwashe Muvezwa", "kuzivakwashe.muvezwa@structureit.net", "password1"));
        userRepository.save(new User(2,  "Mushagi Mayibo", "mushagi.mayibo@structureit.net", "password1"));
        userRepository.save(new User(3,  "Eartha Hansmann", "eartha.hansmann@structureit.net", "password1"));
        return "Done";
    }

    public User addUser(long id, String name, String email, String password){
        return userRepository.save(new User(id, name, email, password));
    }

    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(long id){
        return userRepository.findOne(id);
    }

    public User getUserByName(String name) {
        return userRepository.findByName(name);
    }

    public User getUserByNameAndEmail(String name, String email) {
        return userRepository.findByNameAndEmail(name,email);
    }

    public Boolean deleteUser(long id) {
        User user = userRepository.findOne(id);

        if (user != null) {
            userRepository.delete(user);
            return true;
        }

        log.warn("Stop fooling around, user with id {} doesn't exist",id);
        return false;
    }


}
