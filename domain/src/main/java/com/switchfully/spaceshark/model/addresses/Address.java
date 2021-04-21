package com.switchfully.spaceshark.model.addresses;

import com.switchfully.spaceshark.utils.ValidationUtil;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "street_name")
    private String streetName;

    @Column(name = "street_number")
    private String streetNumber;

    @ManyToOne
    @JoinColumn( name = "postal_code_id")
    private PostalCode postalCode;

    public Address() {
    }

    public Address(String streetName, String streetNumber, PostalCode postalCode) {
        ValidationUtil.throwExceptionIfNullOrEmptyOrBlank(streetName, "street");
        ValidationUtil.throwExceptionIfNullOrEmptyOrBlank(streetNumber, "street number");
        ValidationUtil.throwExceptionIfNullObject(postalCode, "postal code");
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        ValidationUtil.throwExceptionIfNullOrEmptyOrBlank(streetName, "street");
        this.streetName = streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        ValidationUtil.throwExceptionIfNullOrEmptyOrBlank(streetNumber, "house number");
        this.streetNumber = streetNumber;
    }

    public PostalCode getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(PostalCode postalCode) {
        this.postalCode = postalCode;
    }
}
