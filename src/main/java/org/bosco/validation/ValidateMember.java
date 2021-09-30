package org.bosco.validation;

import org.bosco.dtos.MemberDTO;
import org.bosco.exceptions.InvalidNameException;

import java.util.Locale;

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

    public MemberDTO getDto() {
        return dto;
    }

    public void setDto (MemberDTO dto){
        this.dto = dto;
    }
}
