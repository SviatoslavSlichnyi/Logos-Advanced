package ua.lviv.magazine.controller.response;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundResponse extends RuntimeException {
    public NotFoundResponse() {
    }

    public NotFoundResponse(String message) {
        super(message);
    }
}
