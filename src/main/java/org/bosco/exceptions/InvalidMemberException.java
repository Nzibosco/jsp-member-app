package org.bosco.exceptions;

public class InvalidMemberException extends RuntimeException{

    public  InvalidMemberException (){
        super("ERROR === Adding member failed. Make sure all required details have been provided " +
                "before attempting to add a new member.");
    }

    public InvalidMemberException (String message){
        super (message);
    }
}
