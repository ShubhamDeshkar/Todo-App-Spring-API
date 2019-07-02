package com.todoapp.TodoApp.Todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/jpa/users")
@CrossOrigin(origins = {"http://localhost:4200", "https://quirky-morse-bbfee4.netlify.com"})
public class TodoJPAResource {

    @Autowired
    private TodoHardcodedService service;

    @Autowired
    private TodoJPARepository todoJPARepository;

    @GetMapping("/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username) {
        return todoJPARepository.findByUsername(username);
    }

    @DeleteMapping("/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable Long id) {
        Todo deletedTodo = service.deleteTodo(id);
        if (deletedTodo != null)
            return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{username}/todos/{id}")
    public Todo getTodo(@PathVariable String username, @PathVariable Long id) {
        return todoJPARepository.findById(id).get();
    }

    @PutMapping("/{username}/todos/{id}")
    public ResponseEntity<Todo> saveTodo(@PathVariable String username, @PathVariable Long id, @RequestBody Todo todo) {
        Todo updatedTodo = service.saveTodo(todo);
        return new ResponseEntity<>(updatedTodo, HttpStatus.OK);
    }

    @PostMapping("/jpa/users/{username}/todos")
    public ResponseEntity<Void> saveTodo(@PathVariable String username, @RequestBody Todo todo) {
        Todo createdTodo = service.saveTodo(todo);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
