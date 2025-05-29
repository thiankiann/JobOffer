package com.junioroffers.domain.loginandregister;

public class DuplicateKeyException extends RuntimeException{
    public DuplicateKeyException(String message) {
        super(message);
    }
}
