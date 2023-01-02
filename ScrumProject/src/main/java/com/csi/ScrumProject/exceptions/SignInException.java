package com.csi.ScrumProject.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class SignInException extends Exception {
    public SignInException(String m) {
        super(m);
    }
}
