package org.bosco.dtos;
import org.bosco.entities.JspMember;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class MemberDTO {

    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;
    private String address;
    private String dob;

    /**
     * No args constructor for MemberDTO
     */
    public MemberDTO (){}

    /**
     * MemberDTO constructor with all args
     */
    public MemberDTO (String firstname, String lastname, String email, String phoneNumber, String address, String dob){
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.dob = dob;
    }

    /**
     * Method to create a member from a DTO
     * @return
     */
    public JspMember createMemberFromDto (){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY/MM/dd");

        LocalDate dateOfBirth = LocalDate.parse(dob);
        System.out.println("Formatted DOB: " + formatter.format(dateOfBirth));

        JspMember member = JspMember.getInstance();
        member.setFirstname(firstname);
        member.setLastname(lastname);
        member.setEmail(email);
        member.setPhoneNumber(phoneNumber);
        member.setAddress(address);
        member.setDob(dateOfBirth);

        return member;
    }


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MemberDTO)) return false;
        MemberDTO memberDTO = (MemberDTO) o;
        return getFirstname().equals(memberDTO.getFirstname()) && getLastname().equals(memberDTO.getLastname()) && getEmail().equals(memberDTO.getEmail()) && getPhoneNumber().equals(memberDTO.getPhoneNumber()) && getAddress().equals(memberDTO.getAddress()) && getDob().equals(memberDTO.getDob());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstname(), getLastname(), getEmail(), getPhoneNumber(), getAddress(), getDob());
    }
}
