package com.findbook.demo.dao;

import com.findbook.demo.entities.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    //esto no se si esta bien
    @Override
    public List<Employee> findAll();


}
