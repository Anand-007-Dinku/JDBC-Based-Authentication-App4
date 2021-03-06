package com.Dinku007.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anand SN
 */

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService service;

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){

        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

        provider.setUserDetailsService(service);

        //provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());

        provider.setPasswordEncoder(new BCryptPasswordEncoder(11));

        return provider;

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/home/").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }
}
