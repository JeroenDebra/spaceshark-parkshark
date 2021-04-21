package com.switchfully.spaceshark.dtos;

public class PostalCodeDTO {

    private String postalCode;
    private String city;

    public PostalCodeDTO() {
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
