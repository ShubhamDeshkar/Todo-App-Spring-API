package com.todoapp.TodoApp.Todo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoJPARepository extends JpaRepository<Todo, Long>{
    public List<Todo> findByUsername(String username);
}
