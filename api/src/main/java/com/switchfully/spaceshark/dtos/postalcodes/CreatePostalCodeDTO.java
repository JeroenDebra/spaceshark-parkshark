package com.switchfully.spaceshark.dtos.postalcodes;

public class CreatePostalCodeDTO {

    private String postalCode;
    private String city;

    public CreatePostalCodeDTO() {
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
