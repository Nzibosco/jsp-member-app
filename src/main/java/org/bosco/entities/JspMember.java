package org.bosco.entities;

import java.time.LocalDate;
import java.util.Objects;

public class JspMember {

    private String firstname;
    private String lastname;
    private LocalDate dob;
    private String address;
    private String phoneNumber;
    private String email;

    /**
     * No args constructor
     */
    private JspMember (){}

    /**
     * Constructor with all args
     */
    private JspMember(String firstname, String lastname, String phoneNumber, String email, LocalDate dob, String address){
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.dob = dob;
        this.address = address;
    }

    /**
     * Static method to create a no args constructor
     * @return
     */

    public static JspMember getInstance() {
        return new JspMember();
    }

    /**
     * static method to create a constructor with all args
     * @return
     */
    public static JspMember getInstance(String firstname, String lastname, String phoneNumber, String email, LocalDate dob, String address){

        return new JspMember (firstname, lastname, phoneNumber, email, dob, address);
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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JspMember)) return false;
        JspMember that = (JspMember) o;
        return getFirstname().equals(that.getFirstname()) && getLastname().equals(that.getLastname()) && getDob().equals(that.getDob()) && getAddress().equals(that.getAddress()) && getPhoneNumber().equals(that.getPhoneNumber()) && getEmail().equals(that.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstname(), getLastname(), getDob(), getAddress(), getPhoneNumber(), getEmail());
    }

    @Override
    public String toString() {
        return "Member: {" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", dob=" + dob +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
