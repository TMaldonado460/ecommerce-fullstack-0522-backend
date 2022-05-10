package com.example.demo;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = Logger.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> respuestaErrores(Exception e, WebRequest w) {
        logger.error(e.getMessage() + " -- " + w.getDescription(true).toString());
        return new ResponseEntity("Error: " + e.getClass(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
