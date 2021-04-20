package com.switchfully.spaceshark.model;

import com.switchfully.spaceshark.utils.ValidationUtil;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToOne
    @JoinColumn(name = "member_address")
    private MemberAddress memberAddress;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "licence_plate")
    private String licencePlate;

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    public Member(String firstName, String lastName, MemberAddress memberAddress, String phoneNumber, String email, String licencePlate) {
        ValidationUtil.throwExceptionIfNullOrEmptyOrBlank(firstName, "member firstname");
        ValidationUtil.throwExceptionIfNullOrEmptyOrBlank(lastName, "member lastname");
        ValidationUtil.throwExceptionIfNullOrEmptyOrBlank(licencePlate, "member licence plate");
        ValidationUtil.throwExceptionIfEmailNullEmptyBlankOrInvalid(email, "email");
        ValidationUtil.throwExceptionIfPhoneNumberNullEmptyBlankOrInvalid(phoneNumber, "phonenumber");
        ValidationUtil.throwExceptionIfNullObject(memberAddress, "address");

        this.firstName = firstName;
        this.lastName = lastName;
        this.memberAddress = memberAddress;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.licencePlate = licencePlate;
        this.registrationDate = LocalDate.now();
    }

    public Member() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public MemberAddress getAddress() {
        return memberAddress;
    }

    public void setAddress(MemberAddress memberAddress) {
        this.memberAddress = memberAddress;
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

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }
}
