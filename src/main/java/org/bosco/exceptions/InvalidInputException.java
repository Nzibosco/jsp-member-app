package org.bosco.exceptions;

public class InvalidInputException extends RuntimeException {

    public InvalidInputException (){
        super("ERROR === the input you provided is invalid");
    }

    public InvalidInputException (String message){
        super(message);
    }
}
