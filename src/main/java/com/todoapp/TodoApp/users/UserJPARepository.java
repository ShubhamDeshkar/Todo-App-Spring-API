package com.todoapp.TodoApp.users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJPARepository extends JpaRepository<User, Long>{

}
