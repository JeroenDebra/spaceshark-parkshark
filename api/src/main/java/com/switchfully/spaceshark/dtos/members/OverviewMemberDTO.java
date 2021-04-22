package com.switchfully.spaceshark.dtos.members;

import java.time.LocalDate;

public class OverviewMemberDTO {

    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String licencePlate;
    private LocalDate registrationDate;

    public int getId() {
        return id;
    }

    public OverviewMemberDTO setId(int id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public OverviewMemberDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public OverviewMemberDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public OverviewMemberDTO setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public OverviewMemberDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public OverviewMemberDTO setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
        return this;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public OverviewMemberDTO setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
        return this;
    }
}
