package com.switchfully.spaceshark.dtos.addresses;

import com.switchfully.spaceshark.dtos.postalcodes.PostalCodeDTO;

public class AddressDTO {

    private int id;
    private String StreetName;
    private String StreetNumber;
    private PostalCodeDTO postalCode;

    public AddressDTO() {
    }

    public String getStreetName() {
        return StreetName;
    }

    public AddressDTO setStreetName(String streetName) {
        StreetName = streetName;
        return this;
    }

    public String getStreetNumber() {
        return StreetNumber;
    }

    public AddressDTO setStreetNumber(String streetNumber) {
        StreetNumber = streetNumber;
        return this;
    }

    public PostalCodeDTO getPostalCode() {
        return postalCode;
    }

    public AddressDTO setPostalCode(PostalCodeDTO postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public int getId() {
        return id;
    }

    public AddressDTO setId(int id) {
        this.id = id;
        return this;
    }
}
