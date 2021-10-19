package org.bosco.exceptions;

public class InvalidNameException extends RuntimeException {

    public InvalidNameException(){
        super("ERROR === Name provided is invalid");
    }

    public InvalidNameException (String message){
        super(message);
    }
}
