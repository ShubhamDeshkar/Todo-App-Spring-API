package com.todoapp.TodoApp.Todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoJPARepository extends JpaRepository<Todo, Long>{
    public List<Todo> findByUsername(String username);
}
