package com.findbook.demo.dao;

import com.findbook.demo.entities.User;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public abstract class UserRepository implements CrudRepository<User, Long> {

    //esto no se si esta bien
    @Override
    public abstract List<User> findAll();


}
