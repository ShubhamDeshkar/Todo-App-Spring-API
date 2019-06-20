package com.todoapp.TodoApp.basic.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "https://quirky-morse-bbfee4.netlify.com"})
public class AuthenticationController {
    @GetMapping("/basic-auth")
    public AuthenticatedBean helloWorldBean() {
        return new AuthenticatedBean("Hey! You are authenticated!");
    }
}
