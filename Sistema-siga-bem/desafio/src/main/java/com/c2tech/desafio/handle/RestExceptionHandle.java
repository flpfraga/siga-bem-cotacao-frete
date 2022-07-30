package com.c2tech.desafio.handle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.c2tech.desafio.model.error.ErrorMessage;
import com.c2tech.desafio.model.exception.BadRequestException;
import com.c2tech.desafio.model.exception.ResourceNotFoundException;

@ControllerAdvice
public class RestExceptionHandle {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handlerResourceNotFoundException (ResourceNotFoundException ex){
        ErrorMessage error = new ErrorMessage("Not Found", HttpStatus.NOT_FOUND.value(), "Recurso não encontrado");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> handlerBadRequestException (BadRequestException ex){
        ErrorMessage error = new ErrorMessage("Bad Request", HttpStatus.BAD_REQUEST.value(), "Verifique o CEP");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
