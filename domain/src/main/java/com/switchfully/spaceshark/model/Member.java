package com.switchfully.spaceshark.model;

import com.switchfully.spaceshark.utils.ValidationUtil;

import java.time.LocalDate;

public class Member {

    private String firstName;
    private String lastName;
    private Address address;
    private String phoneNumber;
    private String email;
    private String licencePlate;
    private LocalDate registrationDate;

    public Member(String firstName, String lastName, Address address, String phoneNumber, String email, String licencePlate) {
        ValidationUtil.throwExceptionIfNullOrEmptyOrBlank(firstName, "member firstname");
        ValidationUtil.throwExceptionIfNullOrEmptyOrBlank(lastName, "member lastname");
        ValidationUtil.throwExceptionIfNullOrEmptyOrBlank(licencePlate, "member licence plate");
        ValidationUtil.throwExceptionIfEmailNullEmptyBlankOrInvalid(email, "email");
        ValidationUtil.throwExceptionIfPhoneNumberNullEmptyBlankOrInvalid(phoneNumber, "phonenumber");
        ValidationUtil.throwExceptionIfNullObject(address, "address");

        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
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
