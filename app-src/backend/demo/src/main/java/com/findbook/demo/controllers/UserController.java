package com.findbook.demo.controllers;

import com.findbook.demo.dao.UserRepository;
import com.findbook.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("users")
public class UserController {

    @Autowired
    UserRepository proRep;

    @GetMapping("/new")
    public String displayUserForm(Model model) {
        User nouUser = new User();
        model.addAttribute("user", nouUser);
        return "users/new-user";

    }

    @PostMapping("/save")
    public String createEmployee(User unUser) {

        proRep.save(unUser);

        return "redirect:/users";
    }

    @GetMapping("")
    public String createUser(Model model) {

        List<User> user = proRep.findAll();
        model.addAttribute("projects", user);

        return "users/list-user";
    }

}
