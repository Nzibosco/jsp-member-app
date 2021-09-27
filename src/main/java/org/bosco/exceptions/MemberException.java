package org.bosco.exceptions;

public class MemberException extends RuntimeException{

    private String message;

    public MemberException (){
        super("Exception occurred while adding a member");
    }

    public MemberException (String message){
        super(message);
    }
}
