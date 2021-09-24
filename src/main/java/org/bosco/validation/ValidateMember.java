package org.bosco.validation;

import org.bosco.dtos.MemberDTO;

public class ValidateMember {

    private MemberDTO dto;

    public ValidateMember (){}

    public ValidateMember (MemberDTO dto){
        this.dto = dto;
    }

    public boolean isValid (MemberDTO dto){
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
