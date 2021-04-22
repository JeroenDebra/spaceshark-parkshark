package com.switchfully.spaceshark.dtos.contactpersons;

public class ContactPersonDTO {

    private int id;
    private String name;
    private String gsm;
    private String phoneNumber;
    private String email;

    public int getId() {
        return id;
    }

    public ContactPersonDTO setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ContactPersonDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getGsm() {
        return gsm;
    }

    public ContactPersonDTO setGsm(String gsm) {
        this.gsm = gsm;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public ContactPersonDTO setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ContactPersonDTO setEmail(String email) {
        this.email = email;
        return this;
    }
}
