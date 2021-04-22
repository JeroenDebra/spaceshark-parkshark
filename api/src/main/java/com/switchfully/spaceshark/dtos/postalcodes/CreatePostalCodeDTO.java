package com.switchfully.spaceshark.dtos.postalcodes;

public class CreatePostalCodeDTO {

    private String code;
    private String city;

    public CreatePostalCodeDTO() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
