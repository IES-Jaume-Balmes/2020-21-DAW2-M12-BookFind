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
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
//        TODO: CSRF AUTH, MUST BE ENABLE
        http
                .csrf().disable()
                .authorizeRequests().antMatchers("/admin/**").hasAnyAuthority("ADMIN")
                .and()
                .authorizeRequests().antMatchers("/cart/**").hasAnyAuthority("USER")
                .and()
                .authorizeRequests().antMatchers("/**").permitAll()
                .anyRequest()
                .authenticated().and()
                .formLogin();
        ;

/*        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/books/**", "/h2-console/**", "/login/**", "/user/**") //Permit any conection in this endpoint
                .permitAll()
                .anyRequest()
                .authenticated().and()
                .formLogin();*/

        /*        http
                .authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin();
        */

        //To see the h2 console
        http.headers().frameOptions().disable();


        http.formLogin()
                .failureUrl("/login_error");


        http.formLogin()
                .successHandler(new AuthenticationSuccessHandler() {

                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                                        Authentication authentication) throws IOException, ServletException {

                        System.out.println("Logged user: " + authentication.getName());

                        response.sendRedirect("/");
                    }
                });


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
/*       http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/user/sign-up/**", "/h2-console/**") //Permit any conection in this endpoint
                .permitAll()
                .anyRequest()
                .authenticated().and()
                .formLogin();*/