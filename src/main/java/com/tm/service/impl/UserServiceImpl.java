/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tm.service.impl;

import com.tm.pojo.User;
import com.tm.repository.UserRepository;
import com.tm.service.UserService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service("userDetailsService")
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.getUserByUsername(username);
        
        if(user == null)
            throw new UsernameNotFoundException("User not found!");
        
        Set<GrantedAuthority> authority = new HashSet<>();
        authority.add(new SimpleGrantedAuthority(user.getRole()));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authority);
    }

    @Override
    public User getUserByUsername(String username) {
        return this.userRepository.getUserByUsername(username);
    }
}
