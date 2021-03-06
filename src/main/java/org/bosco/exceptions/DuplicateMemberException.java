package org.bosco.exceptions;

public class DuplicateMemberException extends RuntimeException {

    public DuplicateMemberException (){
        super("ERROR ==== The member you are trying to add already exists");
    }

    public DuplicateMemberException (String message){
        super (message);
    }
}
