package com.rest.webservices.restfulwebservices.exception;

import java.util.Date;

//Used to make a Custom Format for Exception to be shown
//Useful for having a consistent way in the organization
public class ExceptionResponse {
    private Date timeStamp;
    private String message, details;

    public ExceptionResponse(Date timeStamp, String message, String details) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
