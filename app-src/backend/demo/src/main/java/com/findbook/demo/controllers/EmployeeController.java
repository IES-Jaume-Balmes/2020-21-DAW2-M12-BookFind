package com.findbook.demo.controllers;

import com.findbook.demo.dao.EmployeeRepository;
import com.findbook.demo.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("employees")
public class EmployeeController {

    @Autowired
    EmployeeRepository proRep;

    @GetMapping("/new")
    public String displayEmployeeForm(Model model) {
        Employee nouEmpleat = new Employee();
        model.addAttribute("employee", nouEmpleat);
        return " ";
    }

    @PostMapping("/save")
    public String createEmployee(Employee unEmpleat) {

        proRep.save(unEmpleat);

        return "redirect:/employees";
    }

    @GetMapping("")
    public String createEmploye(Model model) {

        List<Employee> employee = proRep.findAll();
        model.addAttribute("projects", employee);

        return "employees/list-employees";
    }

}
