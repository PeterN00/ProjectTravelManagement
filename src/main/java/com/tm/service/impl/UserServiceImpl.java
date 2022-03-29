/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tm.service.impl;

import com.tm.pojo.User;
import com.tm.repository.UserRepository;
import com.tm.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
            
    @Override
    public List<User> getUsers() {
        return this.userRepository.getUsers();
    }
    
    @Override
    public void addUser(User user){
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        userRepository.addUser(user);
    }
}
