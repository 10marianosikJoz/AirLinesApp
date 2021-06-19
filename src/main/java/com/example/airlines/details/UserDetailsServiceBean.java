package com.example.airlines.details;

import com.example.airlines.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class UserDetailsServiceBean {

    @Bean
    public UserDetailsService userDetailsService () {

        return new UserService();
    }
}
