package com.task2.carriergot2.exceptions;

public class UpdateWorkOrderStateDeciderNotFoundException extends RuntimeException{
    public UpdateWorkOrderStateDeciderNotFoundException(Long id) {
        super("UpdateWorkOrderStateDecider id not found" + id);
    }
}
