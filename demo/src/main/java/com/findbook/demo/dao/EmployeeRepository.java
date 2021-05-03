package com.findbook.demo.dao;

import com.findbook.demo.entities.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public abstract class EmployeeRepository implements CrudRepository<Employee, Long> {

    //esto no se si esta bien
    @Override
    public abstract List<Employee> findAll();


}
