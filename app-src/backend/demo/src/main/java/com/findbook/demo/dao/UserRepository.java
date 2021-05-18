package com.findbook.demo.dao;

import com.findbook.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {


    @Override
    public List<User> findAll();


    User findOneByUsername(String username);

    User findByEmail(String email);


}
