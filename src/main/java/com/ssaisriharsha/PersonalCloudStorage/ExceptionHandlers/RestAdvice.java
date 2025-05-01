package com.ssaisriharsha.PersonalCloudStorage.ExceptionHandlers;

import com.ssaisriharsha.PersonalCloudStorage.Exceptions.InvalidRequestParameterException;
import com.ssaisriharsha.PersonalCloudStorage.Exceptions.UserExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.file.FileAlreadyExistsException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class RestAdvice {
    @ExceptionHandler(UserExistsException.class)
    public ResponseEntity<HashMap<String, String>> handleUserExistsException(UserExistsException e) {
        HashMap<String, String> map=new HashMap<>();
        map.put("message", e.getMessage());
        return new ResponseEntity<>(map, HttpStatus.CONFLICT);
    }
    @ExceptionHandler(FileAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleFileExistsException(FileAlreadyExistsException e) {
        HashMap<String, String> map=new LinkedHashMap<>();
        map.put("message", "The file with the name" + e.getFile() + " already exists. Please rename the file and upload or upload with overwrite=true");
        map.put("timestamp", LocalDateTime.now().toString());
        return new ResponseEntity<>(map, HttpStatus.CONFLICT);
    }
    @ExceptionHandler(InvalidRequestParameterException.class)
    public ResponseEntity<Map<String, String>> handleInvalidRequestParameterException(InvalidRequestParameterException e) {
        HashMap<String, String> map=new LinkedHashMap<>();
        map.put("message", e.getMessage());
        map.put("timestamp", LocalDateTime.now().toString());
        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
    }
}
