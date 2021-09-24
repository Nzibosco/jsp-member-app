package org.bosco.repository;

import org.bosco.dtos.MemberDTO;
import org.bosco.entities.JspMember;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MembersRepo {

    /**
     * A map containing all members
     */
    private HashMap<Integer, JspMember> members;

    public MembersRepo (){
        members = new LinkedHashMap<>();
    }

    public void addMember (String firstname, String lastname, String email, String phoneNumber, String address, String dateOfBirth){

        MemberDTO memberDTO = new MemberDTO(firstname, lastname, email, phoneNumber, address, dateOfBirth);
        JspMember member = memberDTO.createMemberFromDto();
        members.put(generateNumber(members), member);
        System.out.println("New Member added Successfully");

    }

    public void printAllMembers (){
        for(Map.Entry<Integer, JspMember> member : members.entrySet()){
            System.out.println("=========================================================");
            System.out.println("Member number: " + member.getKey());
            System.out.println("Member details: ");
            System.out.println(member.getValue().toString());
        }
    }

    private int generateNumber (HashMap<Integer, JspMember> members){
        int size = members.size();
        return size + 1;
    }

}
