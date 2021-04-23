package com.switchfully.spaceshark.dtos.members;

import com.switchfully.spaceshark.dtos.addresses.AddressDTO;

import java.time.LocalDate;

public class MemberDTO {

    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String licencePlate;
    private LocalDate registrationDate;
    private AddressDTO address;

    public MemberDTO setId(int id) {
        this.id = id;
        return this;
    }

    public MemberDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public MemberDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public MemberDTO setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public MemberDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public MemberDTO setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
        return this;
    }

    public MemberDTO setRegistrationDate(LocalDate date) {
        this.registrationDate = date;
        return this;
    }

    public MemberDTO setAddress(AddressDTO address) {
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

    public AddressDTO getAddress() {
        return address;
    }
}
