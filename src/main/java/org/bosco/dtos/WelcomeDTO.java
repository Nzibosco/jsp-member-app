package org.bosco.dtos;

public class WelcomeDTO {

    private String message;
    private String todaysDate;


    public WelcomeDTO(){}

    public WelcomeDTO (String message, String date){
        this.message = message;
        todaysDate = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTodaysDate() {
        return todaysDate;
    }

    public void setTodaysDate(String todaysDate) {
        this.todaysDate = todaysDate;
    }

}

