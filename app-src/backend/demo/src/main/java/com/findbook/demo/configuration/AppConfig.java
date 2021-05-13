package com.findbook.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class AppConfig {
    /*The necessary objects for the dependency injection*/
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}