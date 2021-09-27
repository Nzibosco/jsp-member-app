package org.bosco.validation;

import org.bosco.dtos.MemberDTO;

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

        return dto;
    }

    public MemberDTO getDto() {
        return dto;
    }

    public void setDto (MemberDTO dto){
        this.dto = dto;
    }
}
