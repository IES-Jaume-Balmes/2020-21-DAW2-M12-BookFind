package com.findbook.demo.services;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service //marks a java class as a bean, @Component
public class EmailValidator implements Predicate<String> {

    @Override
    public boolean test(String s) {
        //        TODO: Regex to validate email
        return true;
    }
}
