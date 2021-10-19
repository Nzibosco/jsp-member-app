package org.bosco.exceptions;

public class InvalidEmailException extends RuntimeException{

    public InvalidEmailException(){
        super("ERROR ==== Please provide a valid email for this member");
    }

    public InvalidEmailException(String message){
        super(message);
    }
}
