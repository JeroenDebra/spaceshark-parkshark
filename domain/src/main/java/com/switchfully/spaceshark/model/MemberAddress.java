package com.switchfully.spaceshark.model;

import com.switchfully.spaceshark.utils.ValidationUtil;

import javax.persistence.*;

@Entity
@Table(name = "member_addresses")
public class MemberAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String street;
    private String houseNumber;
    private String postcode;
    private String city;

    public MemberAddress(String street, String houseNumber, String postcode, String city) {
        ValidationUtil.throwExceptionIfNullOrEmptyOrBlank(street, "street");
        ValidationUtil.throwExceptionIfNullOrEmptyOrBlank(houseNumber, "house number");
        ValidationUtil.throwExceptionIfNullOrEmptyOrBlank(postcode, "postcode");
        ValidationUtil.throwExceptionIfNullOrEmptyOrBlank(city, "city");
        this.street = street;
        this.houseNumber = houseNumber;
        this.postcode = postcode;
        this.city = city;
    }

    public MemberAddress() {
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
