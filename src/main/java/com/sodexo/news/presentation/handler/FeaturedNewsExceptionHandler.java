package com.sodexo.news.presentation.handler;
import com.sodexo.news.domain.model.Notification;
import com.sodexo.news.util.Constants;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class FeaturedNewsExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Notification> handleGenericException(Exception e) {
        Notification notification = new Notification(Constants.GENERIC_ERROR_MESSAGE , HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(notification, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Notification> handleNotFoundException(EntityNotFoundException e) {
        Notification notification = new Notification(Constants.NOT_FOUND_ERROR_MESSAGE , HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(notification, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Notification> handleNoSuchElementException(NoSuchElementException e) {
        Notification notification = new Notification(Constants.NOT_FOUND_ERROR_MESSAGE , HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(notification, HttpStatus.NOT_FOUND);
    }
}