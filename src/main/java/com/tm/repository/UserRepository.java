/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tm.repository;

import java.util.List;
import com.tm.pojo.User;
/**
 *
 * @author Admin
 */
public interface UserRepository {
    List<User> getUsers();
    void addUser(User user);
    User getUserByUsername(String username);
    void editUser(User user);
}
