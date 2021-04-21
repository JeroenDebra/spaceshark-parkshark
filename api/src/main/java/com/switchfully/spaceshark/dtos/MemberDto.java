package com.switchfully.spaceshark.dtos;

import com.switchfully.spaceshark.model.addresses.Address;

import java.time.LocalDate;

public class MemberDto {

    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String licencePlate;
    private LocalDate registrationDate;
    private int address_id;

    public MemberDto setId(int id) {
        this.id = id;
        return this;
    }

    public MemberDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public MemberDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public MemberDto setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public MemberDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public MemberDto setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
        return this;
    }

    public MemberDto setRegistrationDate() {
        this.registrationDate = LocalDate.now();
        return this;
    }

    public MemberDto setAddress_id(int address_id) {
        this.address_id = address_id;
        return this;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public int getAddress_id() {
        return address_id;
    }
}
