package org.bosco.repository;

import org.bosco.dtos.MemberDTO;
import org.bosco.entities.JspMember;

import java.util.*;

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

    public Iterable<JspMember> getAll (){
        return members.values();
    }

    public void printAllMembers (){
        for(Map.Entry<Integer, JspMember> member : members.entrySet()){
            System.out.println("=========================================================");
            System.out.println("Member number: " + member.getKey());
            System.out.println("Member details: ");
            System.out.println(member.getValue().toString());
        }

        System.out.println("\n ====Printing members using iterator ====== ");
        for(Iterator<Map.Entry<Integer,JspMember>> iterator = members.entrySet().iterator(); iterator.hasNext();){
                Map.Entry<Integer, JspMember> m = iterator.next();
                System.out.println("..................Member key data ..........................");
                System.out.println("Member number: " + m.getKey());
                System.out.println("Member fullnames: " + m.getValue().getFirstname() + " "+
                        m.getValue().getLastname());

        }
    }

    public Optional<JspMember> findMember (String lastname){

        Optional<JspMember> member = Optional.empty();

        Iterator<Map.Entry<Integer, JspMember>> iter = members.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry<Integer, JspMember> entry = iter.next();
            System.out.println("The entry key for the input iterated is " + entry.getKey() + " and firstname is " +
                    entry.getValue().getFirstname());
            JspMember m = entry.getValue();
            if(lastname.equalsIgnoreCase(m.getLastname())){
                member = Optional.of(m);
                break;
            }
        }

        return member;
    }

    private int generateNumber (HashMap<Integer, JspMember> members){
        int size = members.size();
        return size + 1;
    }

}
