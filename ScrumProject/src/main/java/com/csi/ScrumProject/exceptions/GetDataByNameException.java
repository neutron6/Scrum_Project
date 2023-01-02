package com.csi.ScrumProject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class GetDataByNameException extends Exception {
    public GetDataByNameException(String s) {
        super();

    }


}
