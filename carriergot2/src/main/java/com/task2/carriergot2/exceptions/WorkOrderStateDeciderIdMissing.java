package com.task2.carriergot2.exceptions;

public class WorkOrderStateDeciderIdMissing extends RuntimeException{
    public WorkOrderStateDeciderIdMissing(String type) {
        super(type + " ID is missing in request");
    }
}
