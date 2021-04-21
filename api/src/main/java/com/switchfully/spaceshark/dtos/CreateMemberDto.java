package com.switchfully.spaceshark.dtos;

public class CreateMemberDto {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String licencePlate;
    private CreateAddressDTO address;

    public CreateMemberDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public CreateMemberDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public CreateMemberDto setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public CreateMemberDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public CreateMemberDto setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
        return this;
    }

    public CreateMemberDto setAddress(CreateAddressDTO address) {
        this.address = address;
        return this;
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

    public CreateAddressDTO getAddress() {
        return address;
    }
}
