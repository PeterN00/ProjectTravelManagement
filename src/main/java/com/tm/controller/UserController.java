/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tm.controller;

import com.tm.pojo.User;
import com.tm.service.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Admin
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    
    @RequestMapping("/register")
    public String register(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("users", this.userService.getUsers());
        return "register";
    }
    
    @PostMapping("/register")
    public String registerHandler(Model model,
            @ModelAttribute(value = "user") @Valid User user, 
            BindingResult result){
        if(result.hasErrors() == true){
            return "register";
        }
        
        String msg;
        if(user.getPassword().equals(user.getRetypePassword())){
            userService.addUser(user);
            return "redirect:/";
        }else
            msg = "Password does not match!";
        
        model.addAttribute("msg", msg);
        
        return "register";
    }
}
