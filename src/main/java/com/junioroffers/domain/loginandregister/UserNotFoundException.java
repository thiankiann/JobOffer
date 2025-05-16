package com.junioroffers.domain.loginandregister;

class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String userNotFound){
        super(userNotFound);
    }
}
