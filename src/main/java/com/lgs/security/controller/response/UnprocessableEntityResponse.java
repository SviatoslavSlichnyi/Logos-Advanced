package com.lgs.security.controller.response;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class UnprocessableEntityResponse extends RuntimeException {
    public UnprocessableEntityResponse() {
    }

    public UnprocessableEntityResponse(String message) {
        super(message);
    }
}
