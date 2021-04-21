package com.switchfully.spaceshark.model.addresses;

import com.switchfully.spaceshark.utils.ValidationUtil;

import javax.persistence.*;

@Entity
@Table(name = "postal_code")
public class PostalCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "pcode")
    private String postalCode;

    @Column(name = "city")
    private String city;

    public PostalCode() {
    }

    public PostalCode(String postalCode, String city) {
        ValidationUtil.throwExceptionIfNullOrEmptyOrBlank(postalCode, "postal code");
        ValidationUtil.throwExceptionIfNullOrEmptyOrBlank(city, "city");
        this.postalCode = postalCode;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        ValidationUtil.throwExceptionIfNullOrEmptyOrBlank(postalCode, "postal code");
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        ValidationUtil.throwExceptionIfNullOrEmptyOrBlank(city, "city");
        this.city = city;
    }
}
