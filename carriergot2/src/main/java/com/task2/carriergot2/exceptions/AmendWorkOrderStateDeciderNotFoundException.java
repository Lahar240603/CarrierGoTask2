package com.task2.carriergot2.exceptions;

public class AmendWorkOrderStateDeciderNotFoundException extends RuntimeException{
    public AmendWorkOrderStateDeciderNotFoundException(long dbId) {
        super("AmendWorkOrderStateDecider id not found" + dbId);
    }
}
