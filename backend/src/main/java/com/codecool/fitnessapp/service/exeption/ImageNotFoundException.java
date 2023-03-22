package com.codecool.fitnessapp.service.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ImageNotFoundException extends Exception {
    public ImageNotFoundException(String message) {
        super(message);
    }
}
