/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tm.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Admin
 */
@Configurable
public class SpringSecurityConfig {
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        BCryptPasswordEncoder b = new BCryptPasswordEncoder();
        return b;
    }
}
