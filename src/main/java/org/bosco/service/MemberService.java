package org.bosco.service;

import org.bosco.dtos.MemberDTO;
import org.bosco.entities.JspMember;
import org.bosco.exceptions.FieldsEmptyException;
import org.bosco.exceptions.InvalidInputException;
import org.bosco.exceptions.InvalidMemberException;
import org.bosco.exceptions.InvalidNameException;
import org.bosco.repository.MembersRepo;
import org.bosco.validation.ValidateMember;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

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

                try {

                    boolean validName = validate.validateName(cleanDto.getFirstname(), cleanDto.getLastname());
                    if(validName) {
                        repo.addMember(cleanDto.getFirstname(), cleanDto.getLastname(), cleanDto.getEmail(),
                                cleanDto.getPhoneNumber(), cleanDto.getAddress(), cleanDto.getDob());
                    }
                } catch (InvalidNameException e){
                    System.out.println(e.getMessage());
                }

            } else {
                throw new FieldsEmptyException();
            }
        }
        else {
            throw new InvalidMemberException();
        }
    }

    public Iterable<MemberDTO> getMembers (){
        List<MemberDTO> memberList = new ArrayList<>();
        MemberDTO dto = new MemberDTO();
        if(repo.getAll() != null){
            repo.getAll().forEach(member -> memberList.add(dto.createDTOfromMember(member)));
        }

        return memberList;

    }

    public Optional<JspMember> findMemberByLastname(String lastname){
        if(null == lastname || lastname.isEmpty()){
            throw new InvalidInputException("ERROR === The lastname input entered is invalid");
        }

        return repo.findMember(lastname);
    }

    public void printMembers (){
        // Check if the request came from authentic source? Feature to be added later
        System.out.println("=== Prepping to Print all members ..................");
        repo.printAllMembers();
    }

}
