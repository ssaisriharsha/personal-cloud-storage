package com.ssaisriharsha.PersonalCloudStorage.ExceptionHandlers;

import com.ssaisriharsha.PersonalCloudStorage.Exceptions.UserExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;

@ControllerAdvice
public class RestAdvice {
    @ExceptionHandler(UserExistsException.class)
    public ResponseEntity<HashMap<String, String>> handleUserExistsException(UserExistsException e) {
        HashMap<String, String> map=new HashMap<>();
        map.put("message", e.getMessage());
        return new ResponseEntity<>(map, HttpStatus.CONFLICT);
    }
}
