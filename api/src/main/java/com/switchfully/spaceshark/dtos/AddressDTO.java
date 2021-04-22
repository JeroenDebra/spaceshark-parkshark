package com.switchfully.spaceshark.dtos;

import com.switchfully.spaceshark.dtos.postalcodes.PostalCodeDTO;

public class AddressDTO {

    private String StreetName;
    private String StreetNumber;
    private PostalCodeDTO postalCode;

    public AddressDTO() {
    }

    public String getStreetName() {
        return StreetName;
    }

    public void setStreetName(String streetName) {
        StreetName = streetName;
    }

    public String getStreetNumber() {
        return StreetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        StreetNumber = streetNumber;
    }

    public PostalCodeDTO getPostalCodeDTO() {
        return postalCode;
    }

    public void setPostalCodeDTO(PostalCodeDTO postalCodeDTO) {
        this.postalCode = postalCodeDTO;
    }

}
