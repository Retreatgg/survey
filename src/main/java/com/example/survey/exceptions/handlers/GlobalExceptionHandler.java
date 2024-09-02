package com.example.survey.exceptions.handlers;

import com.example.survey.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<AppError> handleUserNotFoundEx(UserNotFoundException exception) {
        return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                exception.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(QuestionNotFoundException.class)
    public ResponseEntity<AppError> handleQuestionNotFoundEx(QuestionNotFoundException exception) {
        return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                exception.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InstituteNotFoundException.class)
    public ResponseEntity<AppError> handleInstituteNotFoundEx(InstituteNotFoundException exception) {
        return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                exception.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<AppError> handlePostNotFoundEx(PostNotFoundException exception) {
        return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                exception.getMessage()), HttpStatus.NOT_FOUND);
    }
}
