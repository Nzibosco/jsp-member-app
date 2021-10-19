package org.bosco;

import org.bosco.dtos.MemberDTO;
import org.bosco.entities.JspMember;
import org.bosco.service.MemberService;

import java.util.Optional;

public class AppDriver {

    public static void main (String [] args){
        System.out.println("Java Server Page Demo Application");

        MemberService service;
        service = new MemberService();
        MemberDTO dto;


        String firstname, lastname, email, phoneNumber, address, dob;

        firstname = "nik";
        lastname = "Ish2";
        email = "nikishi@email.rw";
        phoneNumber = "605-000-0403";
        address = "1400 Alt Run, Nashville, TN 31211";
        dob = "1907-05-10";

        dto = new MemberDTO(firstname, lastname, email, phoneNumber, address, dob);
        try {
            service.addMember(dto);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }


        firstname = "Jean Bosco";
        lastname = "nzeyi";
        email = "conta_ct9@0email.10om";
        phoneNumber = "198-999-8970";
        address = "12 KK street, Kigali, RW 14152";
        dob = "1093-01-01";

        dto = new MemberDTO(firstname, lastname, email, phoneNumber, address, dob);
        try {
            service.addMember(dto);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        firstname = "Nique";
        lastname = "SengaMungu";
        email = "iquesenga@email.com";
        phoneNumber = "002-220-3020";
        address = "1st Nyungwe West Rd, Kitabi Ecocenter Ltd. & Friends of Nyungwe, Nymgbe, Rwanda 34345";
        dob = "1988-01-21";

        dto = new MemberDTO(firstname, lastname, email, phoneNumber, address, dob);
        try {
            service.addMember(dto);
        } catch (Exception e){
            System.out.println(e.getMessage());

        }

        dto = null;

        try {
            service.addMember(dto);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        service.printMembers();

        System.out.println("==== METHOD TO FIND A MEMBER BY LAST NAME ===== ");
        Optional<JspMember> optional = service.findMemberByLastname("nzeyi");
        System.out.println(optional);

    }
}
