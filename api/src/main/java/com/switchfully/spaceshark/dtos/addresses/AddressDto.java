package com.switchfully.spaceshark.dtos.addresses;

import com.switchfully.spaceshark.dtos.postalcodes.PostalCodeDTO;

public class AddressDto {

    private int id;
    private String StreetName;
    private String StreetNumber;
    private PostalCodeDTO postalCode;

    public AddressDto() {
    }

    public String getStreetName() {
        return StreetName;
    }

    public AddressDto setStreetName(String streetName) {
        StreetName = streetName;
        return this;
    }

    public String getStreetNumber() {
        return StreetNumber;
    }

    public AddressDto setStreetNumber(String streetNumber) {
        StreetNumber = streetNumber;
        return this;
    }

    public PostalCodeDTO getPostalCode() {
        return postalCode;
    }

    public AddressDto setPostalCode(PostalCodeDTO postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public int getId() {
        return id;
    }

    public AddressDto setId(int id) {
        this.id = id;
        return this;
    }
}
