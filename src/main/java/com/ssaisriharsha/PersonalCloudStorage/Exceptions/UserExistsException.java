package com.ssaisriharsha.PersonalCloudStorage.Exceptions;

public class UserExistsException extends RuntimeException {
    public UserExistsException(String message) {
        super(message);
    }
}
