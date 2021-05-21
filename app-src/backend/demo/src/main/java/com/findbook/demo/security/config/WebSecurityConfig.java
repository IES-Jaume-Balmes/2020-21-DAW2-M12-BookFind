package com.findbook.demo.security.config;

import com.findbook.demo.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {//Acces to http security
        //super.configure(http);
        //csrf Cross-Site Request Forgery CSRF --> Falsificación de solicitud entre sitios
        /*If you are only creating a service that is used by non-browser clients, you will likely want to disable CSRF protection
        What is the reason to disable csrf in a Spring Boot application?
        1- You are using another token mechanism.
        2- You want to simplify interactions between a client and the server */
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/user/sign-up/**", "/h2-console/**") //Permit any conection in this endpoint
                .permitAll()
                .anyRequest()
                .authenticated().and()
                .formLogin();

        //To see the h2 console
        http.headers().frameOptions().disable();

/*        http.formLogin()
                .loginProcessingUrl("/h2-console/")
                .loginPage("/user/sign-in")
                .permitAll();*/
/*
        http
                .authorizeRequests()
                .antMatchers("/readingList/**").access("hasRole('READER')")
                .antMatchers("/**").permitAll()
                .and()
                .formLogin().loginProcessingUrl("/userAuth")
                .loginPage("/myLogin")
                .failureUrl("/myLogin?error=true");*/
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(userService);
        return provider;
    }
}
