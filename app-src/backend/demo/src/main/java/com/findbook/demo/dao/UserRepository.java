package com.findbook.demo.dao;

import com.findbook.demo.entities.User;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    //esto no se si esta bien
    @Override
    public List<User> findAll();


}
