package com.task2.carriergot2.controlleradvice;

import com.task2.carriergot2.exceptions.AmendWorkOrderStateDeciderNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class AmendWorkOrderStateDeciderControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AmendWorkOrderStateDeciderNotFoundException.class)
    public void amendStateNotFound(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value());
    }
}
