package org.bosco.dtos;

public class ErrorResponseDTO {

    private String ErrorMessage;
    private int statusCode;

    public ErrorResponseDTO (){
    }

    public String getErrorMessage() {
        return ErrorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        ErrorMessage = errorMessage;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
