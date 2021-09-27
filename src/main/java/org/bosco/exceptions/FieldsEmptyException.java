package org.bosco.exceptions;

public class FieldsEmptyException extends RuntimeException {

    public FieldsEmptyException (){
        super("ERROR== One or more fields are empty. Please make sure you fill out all required fields before adding " +
                "a member");
    }

    public FieldsEmptyException (String message) {
        super(message);
    }
}
