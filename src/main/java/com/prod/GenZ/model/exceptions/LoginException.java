package com.prod.GenZ.model.exceptions;

public class LoginException extends Exception{
    public LoginException(){
        super("LOGIN-ERROR");
    }

    public LoginException(String message){
        super(message);
    }
}
