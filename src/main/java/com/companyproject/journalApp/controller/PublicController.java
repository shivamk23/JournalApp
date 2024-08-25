package com.companyproject.journalApp.controller;

import com.companyproject.journalApp.entity.User;
import com.companyproject.journalApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userService;

    @GetMapping("/health-check")
    public String healthCheck(){
        return "ok";
    }

    @PostMapping("/create-user")
    public void  createUser(@RequestBody User user){
        userService.saveNewEntry(user);
    }
}
