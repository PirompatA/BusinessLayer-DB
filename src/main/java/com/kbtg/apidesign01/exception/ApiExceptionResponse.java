package com.kbtg.apidesign01.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ApiExceptionResponse {
    private final String message;
    private final HttpStatus httpsStatus;
    private final ZonedDateTime dateTime;

    public ApiExceptionResponse(String message, HttpStatus httpsStatus, ZonedDateTime dateTime) {
        this.message = message;
        this.httpsStatus = httpsStatus;
        this.dateTime = dateTime;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpsStatus() {
        return httpsStatus;
    }

    public ZonedDateTime getDateTime() {
        return dateTime;
    }
}
