package org.bosco.validation;

import org.bosco.dtos.MemberDTO;

public class ValidateMember {

    private MemberDTO dto;

    public ValidateMember (){}

    public ValidateMember (MemberDTO dto){
        this.dto = dto;
    }

    public boolean isValid (MemberDTO dto) throws Exception{

        if(dto == null || dto.getFirstname() == null || dto.getLastname() == null || dto.getEmail() == null ||
        dto.getPhoneNumber() == null || dto.getAddress() == null || dto.getDob() == null){

            throw new Exception("One or more fields is / are empty");
            //return false;
        }

        return true;
    }

    public MemberDTO cleanDTO (){

        return dto;
    }

    public MemberDTO getDto() {
        return dto;
    }

    public void setDto (MemberDTO dto){
        this.dto = dto;
    }
}
