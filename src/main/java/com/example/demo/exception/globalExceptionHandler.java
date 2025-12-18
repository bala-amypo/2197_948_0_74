package com.example.demo.exception;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.http.ResponseEntity;
import java.util.*;

@RestControllerAdvice
public class globalExceptionHandler{
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map>handleFieldError(MethodArgumentNotValidException ex){
        Map<String,String> error = new HashMap<>();
        ex.getBindingResult().getFieldError().forEach(err -> error.put(err.getField(),err.getDefaultMessage()));
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}