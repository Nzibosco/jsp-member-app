package org.bosco.exceptions;

public class InvalidPhoneException extends RuntimeException {

    public InvalidPhoneException (){
        super("ERROR === The phone number you provided or the format you used is Invalid");
    }

    public InvalidPhoneException (String message){
        super(message);
    }
}
