package org.bosco;

import org.bosco.dtos.MemberDTO;
import org.bosco.service.MemberService;

public class AppDriver {

    public static void main (String [] args){
        System.out.println("Java Server Page Demo Application");

        MemberService service;
        MemberDTO dto;

        service = new MemberService();

        String firstname, lastname, email, phoneNumber, address, dob;

        firstname = "Ni";
        lastname = "Ish";
        email = "nikishi@email.com";
        phoneNumber = "605-000-0403";
        address = "1400 Alt Run, Nashville, TN 31211";
        dob = "1907-05-10";

        dto = new MemberDTO(firstname, lastname, email, phoneNumber, address, dob);
        service.addMember(dto);

        firstname = "Jean Bosco";
        lastname = "Nzeyi";
        email = "contact@email.com";
        phoneNumber = "605-000-0403";
        address = "12 KK street, Kigali, RW 14152";
        dob = "1093-01-01";

        dto = new MemberDTO(firstname, lastname, email, phoneNumber, address, dob);
        service.addMember(dto);

        firstname = "Nique";
        lastname = "Imana";
        email = "iquesenga@email.com";
        phoneNumber = "002-220-3021";
        address = "1st Nyungwe Rd, Kitabi Ecocenter Ltd. Nymgbe, Rwanda 34345";
        dob = "1988-01-01";

        dto = new MemberDTO(firstname, lastname, email, phoneNumber, address, dob);
        service.addMember(dto);

        service.printMembers();

    }
}
