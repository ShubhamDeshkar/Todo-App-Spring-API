package com.todoapp.TodoApp.Todo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoHardcodedService {
    private static List<Todo> todosList = new ArrayList<>();
    private static long idCounter = 0;

    static {
        todosList.add(new Todo(++idCounter, "shubham2307", "Find a job", new Date(), false));
        todosList.add(new Todo(++idCounter, "shubham2307", "Learn angular", new Date(), false));
        todosList.add(new Todo(++idCounter, "shubham2307", "Learn web development", new Date(), false));
        todosList.add(new Todo(++idCounter, "shubham2307", "Buy Groceries", new Date(), false));
        todosList.add(new Todo(++idCounter, "shubham2307", "Fly a spacecship ;)", new Date(), false));
    }

    public List<Todo> findAll() {
        return todosList;
    }

    public Todo deleteTodo(long id) {
        Todo todo = findById(id);
        if (todo != null) {
            if (todosList.remove(todo))
                return todo;
        }
        return null;
    }

    public Todo findById(long id) {
        for (Todo todo: todosList) {
            if (id == todo.getId())
                return todo;
        }
        return null;
    }

    public Todo saveTodo(Todo todo) {
        if (todo.getId() == -1 || todo.getId() == 0) {
            todo.setId(++idCounter);
        }
        else {
            deleteTodo(todo.getId());
        }
        todosList.add(todo);
        return todo;
    }
}