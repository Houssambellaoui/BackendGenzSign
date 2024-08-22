package com.prod.GenZ.model.exceptions;

public class CredentialsLoginException extends LoginException{
    public CredentialsLoginException(){
        super("DONNEES-DE-CONNEXION-INVALIDES");
    }
}
