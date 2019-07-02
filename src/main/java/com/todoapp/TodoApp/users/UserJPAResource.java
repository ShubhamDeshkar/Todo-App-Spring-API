package com.todoapp.TodoApp.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/jpa/users")
@CrossOrigin(origins = {"http://localhost:4200", "https://quirky-morse-bbfee4.netlify.com"})
public class UserJPAResource {

    @Autowired
    private UserJPARepository userJPARepository;

    @PostMapping("/new")
    public ResponseEntity<Void> createUser(User newUser) {
        User createdUser = userJPARepository.save(newUser);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdUser.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    
}
