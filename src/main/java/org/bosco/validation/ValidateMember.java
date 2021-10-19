package org.bosco.validation;

import org.bosco.dtos.MemberDTO;
import org.bosco.exceptions.InvalidEmailException;
import org.bosco.exceptions.InvalidNameException;
import org.bosco.exceptions.InvalidPhoneException;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateMember {

    private MemberDTO dto;

    public ValidateMember (){}

    public ValidateMember (MemberDTO dto){
        this.dto = dto;
    }

    public boolean isValid (MemberDTO dto) {
        if(dto == null){
            return false;
        }
        return true;
    }

    public boolean validateFields (MemberDTO dto){
        if(dto.getFirstname() == null || dto.getLastname() == null || dto.getEmail() == null ||
        dto.getPhoneNumber() == null || dto.getAddress() == null || dto.getDob() == null){
            return false;
        } else if(dto.getFirstname().trim().isEmpty() || dto.getLastname().trim().isEmpty() ||
                dto.getEmail().isEmpty() || dto.getPhoneNumber().isEmpty() || dto.getAddress().isEmpty() ||
                dto.getDob().isEmpty()){
            return false;
        } else {
            return true;
        }
    }

    public MemberDTO cleanDTO (){
        //Make sure the first and last names are capitalized.
        String firstname = dto.getFirstname();
        String lastname = dto.getLastname();
        firstname = firstname.isEmpty()? firstname : firstname.substring(0,1).toUpperCase() + firstname.substring(1);
        lastname = lastname.isEmpty()? lastname: lastname.substring(0,1).toUpperCase() + lastname.substring(1);
        dto.setFirstname(firstname);
        dto.setLastname(lastname);
        String validPhone = validatePhoneNumber(dto.getPhoneNumber());
        dto.setPhoneNumber(validPhone);
        String validEmail = validateEmail(dto.getEmail());
        dto.setEmail(validEmail);
        return dto;
    }

    public boolean validateName (String ... names){
        if(names.length > 0){
            for (String name: names){
                if(name == null || name.trim().isEmpty()){
                    throw new InvalidNameException("Please provide a name before you proceed");
                }

                if (name.length() > 1){

                    String nameRegex = "[A-Za-z- .]{2,}";
                    if(name.matches(nameRegex)){
                        return true;
                    } else {
                        throw new InvalidNameException("ERROR === The name you provided contains non allowable characters. Please try again");
                    }
                } else {
                    throw new InvalidNameException("ERROR === The name you provided has insufficient characters ............");
                }
            }
        }
        return false;
    }

    private String validatePhoneNumber(String phone){

        if(phone.isEmpty())
            throw new InvalidPhoneException("ERROR ==== No phone Number provided");
        String phoneRegex = "([0-9]{3}-){2}[0-9]{4}";

        String [] phoneArr = phone.split("");
        String numRegex = "[0-9]";
        int numCount = 0;
        for(String num : phoneArr){
            if(num.matches(numRegex))
                numCount +=1;
        }

        if(10 != numCount){
            throw new InvalidPhoneException("ERROR ==== Phone number you provided contains " + numCount +
                    " numbers only. Please make sure the phone has exactly 10 numbers " +
                    "and is of correct format (xxx-xxx-xxxx)");
        }

        if(phone.matches(phoneRegex)){
            return phone;
        } else {
            throw new InvalidPhoneException();
        }

    }

    private String validateEmail (String email){

        if(null == email)
            throw new InvalidEmailException("ERROR ==== Please provide an email before you continue");

        if(email.isEmpty())
            throw new InvalidEmailException("ERROR === No email provided. Email is required");

        String emailRegex = "([a-zA-Z0-9._])+@([a-zA-Z0-9._])+.[a-zA-Z0-9]{2,}";
        if(email.matches(emailRegex)){
            return email;
        } else {
            throw new InvalidEmailException("ERROR === The email you provided is of incorrect format."
            + " make sure the email you are providing is correct");
        }
    }

    public MemberDTO getDto() {
        return dto;
    }

    public void setDto (MemberDTO dto){
        this.dto = dto;
    }
}
