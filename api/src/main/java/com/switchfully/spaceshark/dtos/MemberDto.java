package com.switchfully.spaceshark.dtos;

import java.time.LocalDate;

public class MemberDto {

    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String licencePlate;
    private LocalDate registrationDate;
    private AddressDto address;

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

    public MemberDto setRegistrationDate(LocalDate date) {
        this.registrationDate = date;
        return this;
    }

    public MemberDto setAddress(AddressDto address) {
        this.address = address;
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

    public AddressDto getAddress() {
        return address;
    }
}
