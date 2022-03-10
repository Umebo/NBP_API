package com.umebo.nbpapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class InvalidCurrencyCodeException extends Exception{

    public InvalidCurrencyCodeException(String message) {
        super(message);
    }

}
