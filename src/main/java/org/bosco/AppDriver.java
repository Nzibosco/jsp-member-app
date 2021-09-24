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

        firstname = "Nicole";
        lastname = "Ishimwe";
        email = "nicoleishimwe12@gmail.com";
        phoneNumber = "615-600-1413";
        address = "1415 Quail Run, Nashville, TN 37214";
        dob = "1997-05-17";

        dto = new MemberDTO(firstname, lastname, email, phoneNumber, address, dob);
        service.addMember(dto);

        firstname = "Jean Bosco";
        lastname = "Nzeyimana";
        email = "contact@bosconzeyi.com";
        phoneNumber = "615-600-1413";
        address = "12 KK street, Kigali, RW 14152";
        dob = "1993-11-01";

        dto = new MemberDTO(firstname, lastname, email, phoneNumber, address, dob);
        service.addMember(dto);

        firstname = "Dominique";
        lastname = "Nsengimana";
        email = "dominiquesenga@gmail.com";
        phoneNumber = "072-220-3021";
        address = "1st Nyungwe Rd, Kitabi Ecocenter Ltd. Nymgbe, Rwanda 34345";
        dob = "1988-01-01";

        dto = new MemberDTO(firstname, lastname, email, phoneNumber, address, dob);
        service.addMember(dto);

        service.printMembers();

    }
}
