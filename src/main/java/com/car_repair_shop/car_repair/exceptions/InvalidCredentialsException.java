package com.car_repair_shop.car_repair.exceptions;

import org.springframework.security.core.AuthenticationException;

public class InvalidCredentialsException extends AuthenticationException {

    public InvalidCredentialsException(String msg, Throwable t) {
        super(msg, t);
    }

    public InvalidCredentialsException(String msg) {
        super(msg);
    }

}
