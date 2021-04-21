package com.switchfully.spaceshark.model.people;

import com.switchfully.spaceshark.utils.ValidationUtil;

import javax.persistence.*;

@Entity
@Table (name = "contact_person")
public class ContactPerson {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "gsm")
    private String gsm;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    public ContactPerson(String name, String gsm, String phoneNumber, String email) {
        if (!ValidationUtil.isValidEmail(email)){
            throw new IllegalArgumentException("Invalid Email");
        }
        hasAtLeastOneValidNumber(gsm, phoneNumber);
        this.name = name;
        this.gsm = gsm;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public ContactPerson() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGsm() {
        return gsm;
    }

    public void setGsm(String gsm) {
        hasAtLeastOneValidNumber(gsm, phoneNumber);
        this.gsm = gsm;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        hasAtLeastOneValidNumber(gsm, phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!ValidationUtil.isValidEmail(email)){
            throw new IllegalArgumentException("Invalid Email");
        }
        this.email = email;
    }

    private void hasAtLeastOneValidNumber(String gsm, String phone){
//        if ((gsm == null && phone == null) || (gsm == null && phone.equals("")) || (phone == null && gsm.equals("")) || (gsm.equals("") && phone.equals(""))){
//            throw new IllegalStateException ("Please provide at least one valid number");
//        }
        if (!ValidationUtil.isGsmPhoneValidNumber(gsm) && !ValidationUtil.isGsmPhoneValidNumber(phoneNumber)){
            throw new IllegalStateException("Please provide at least a valid number");
        }

    }



}
