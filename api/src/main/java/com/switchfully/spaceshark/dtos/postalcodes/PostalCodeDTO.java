package com.switchfully.spaceshark.dtos.postalcodes;

public class PostalCodeDTO {

    private int id;
    private String postalCode;
    private String city;

    public PostalCodeDTO() {
    }

    public String getPostalCode() {
        return postalCode;
    }

    public PostalCodeDTO setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public String getCity() {
        return city;
    }

    public PostalCodeDTO setCity(String city) {
        this.city = city;
        return this;
    }

    public int getId() {
        return id;
    }

    public PostalCodeDTO setId(int id) {
        this.id = id;
        return this;
    }
}
