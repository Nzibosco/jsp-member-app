package org.bosco.service;

import org.bosco.dtos.MemberDTO;
import org.bosco.exceptions.FieldsEmptyException;
import org.bosco.exceptions.InvalidMemberException;
import org.bosco.exceptions.InvalidNameException;
import org.bosco.repository.MembersRepo;
import org.bosco.validation.ValidateMember;

public class MemberService {

    private MembersRepo repo;
    private ValidateMember validate;

    public MemberService (){
        validate = new ValidateMember();
        repo = new MembersRepo();
    }

    public void addMember (MemberDTO dto) throws InvalidNameException {
        validate.setDto(dto);
        if(validate.isValid(dto)){

            MemberDTO cleanDto = validate.cleanDTO();

            if(validate.validateFields(dto)) {
                repo.addMember(cleanDto.getFirstname(), cleanDto.getLastname(), cleanDto.getEmail(),
                        cleanDto.getPhoneNumber(), cleanDto.getAddress(), cleanDto.getDob());
            } else {
                throw new FieldsEmptyException();
            }
        }
        else {
            throw new InvalidMemberException();
        }
    }

    public void printMembers (){
        // Check if the request came from authentic source? Feature to be added later
        System.out.println("=== Prepping to Print all members ..................");
        repo.printAllMembers();
    }
}
