package com.challenge.todolist.exceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException() {
        super();
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(long id) {
        super("ID not found: " + id);
    }
}
