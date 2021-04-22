package com.switchfully.spaceshark.dtos.postalcodes;

public class PostalCodeDTO {

    private int id;
    private String code;
    private String city;

    public PostalCodeDTO() {
    }

    public String getCode() {
        return code;
    }

    public PostalCodeDTO setCode(String code) {
        this.code = code;
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
