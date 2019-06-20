package com.todoapp.TodoApp.basic.auth;

public class AuthenticatedBean {
    private String message;

    public AuthenticatedBean(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
