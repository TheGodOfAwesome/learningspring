package com.example.demo.services;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;

@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public String addUsers(){
        userRepository.save(new User(1,  "Kuzivakwashe Muvezwa", "kuzivakwashe.muvezwa@structureit.net", "Password1"));
        userRepository.save(new User(2,  "Mushagi Mayibo", "mushagi.mayibo@structureit.net", "Password1"));
        userRepository.save(new User(3,  "Eartha Hansmann", "eartha.hansmann@structureit.net", "Password1"));
        return "Done";
    }

    public String addUser(long id, String name, String email, String password){
        log.info("adding a user");
        /*String error = "";
        boolean test = true;
        if (userRepository.findByEmail(email).getId() == 0){
            error = "Email Is Already In Use";
            return error;
        } else {*/
            userRepository.save(new User(id,  name, email, password));
        //}
        return "Created";
    }

    /*public User addUser(long id, String name, String email, String password){
        return userRepository.save(new User(id, name, email, password));
    }*/

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

    public boolean userExists(String name, String email, String password){
        return userRepository.findByNameAndEmailAndPassword(name, email, password);
    }

    public User userExistsByEmailAndPassword(String email, String password){
        return userRepository.findByEmailAndPassword(email, password);
    }


}
