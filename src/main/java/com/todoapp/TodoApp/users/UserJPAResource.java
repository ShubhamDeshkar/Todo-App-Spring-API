package com.todoapp.TodoApp.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/jpa/users")
@CrossOrigin(origins = {"http://localhost:4200", "https://quirky-morse-bbfee4.netlify.com"})
public class UserJPAResource {

    @Autowired
    private UserJPARepository userJPARepository;

    @PostMapping("/new")
    public ResponseEntity<Void> createUser(@RequestBody User newUser) {
        System.out.println("New User Created");
        User createdUser = userJPARepository.save(newUser);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdUser.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
