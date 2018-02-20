package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    User findByName(String name);
    User findByEmail(String email);
    User findByNameAndEmail(String name, String email);
    Boolean findByNameAndEmailAndPassword(String name, String email, String password);
    User findByEmailAndPassword(String email, String password);
    Boolean findUserByEmail(String Email);
    User findById(long id);
}
