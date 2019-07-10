package com.todoapp.TodoApp.util;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    @GetMapping("/")
    public String showMessage() {
        return "This is an API for Todos application hosted on heroku.com";
    }
}
