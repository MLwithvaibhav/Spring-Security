package com.vaibhav.SpringSecurity.Controller;

import com.vaibhav.SpringSecurity.Model.Users;
import com.vaibhav.SpringSecurity.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping ("/register")
    public Users register(@RequestBody Users user) throws Exception{
        return service.register(user);
    }

    @PostMapping ("/login")
    public String login(@RequestBody Users user) throws Exception{
        System.out.println(user);
        return service.verify(user);
    }
}
