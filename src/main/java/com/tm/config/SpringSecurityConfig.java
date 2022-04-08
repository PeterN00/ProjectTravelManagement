/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tm.config;

import com.tm.handlers.LoginSuccessHandler;
import com.tm.handlers.LogoutHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author Admin
 */
@Configurable
@EnableWebSecurity
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.tm.service",
    "com.tm.repository",
    "com.tm.handlers"
})
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private LoginSuccessHandler loginSuccessHandler;
    @Autowired
    private LogoutHandler logoutHandler;
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        BCryptPasswordEncoder b = new BCryptPasswordEncoder();
        return b;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().usernameParameter("username").passwordParameter("password");
        http.formLogin().defaultSuccessUrl("/");
        http.formLogin().failureUrl("/?error");
        http.formLogin().successHandler(loginSuccessHandler);
        http.logout().logoutSuccessHandler(logoutHandler);
        
        http.exceptionHandling().accessDeniedPage("/?accessDenied");
        
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/users/**/edit").access("hasAnyAuthority('Admin', 'Employee', 'Customer')")
                .antMatchers("/**/book").access("hasAnyAuthority('Admin', 'Employee', 'Customer')")
                .antMatchers("/**/add").access("hasAnyAuthority('Admin', 'Employee')")
                .antMatchers("/**/edit").access("hasAnyAuthority('Admin', 'Employee')")
                .antMatchers("/**/delete").access("hasAuthority('Admin')")
                .antMatchers("/**/statistics").access("hasAuthority('Admin')");
        
        http.csrf().disable();
    }
}
