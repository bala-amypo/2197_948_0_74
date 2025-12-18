package com.example.demo.exception;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.http.*;
import java.util.*;
import com.example.demo.exception.*;

@RestControllerAdvice
public class globalExceptionHandler{
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map>handleFieldError(MethodArgumentNotValidException ex){
        Map<String,String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(err -> errors.put(err.getField(),err.getDefaultMessage()));
        return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<?> handleStudentNotValid(StudentNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
    }
}