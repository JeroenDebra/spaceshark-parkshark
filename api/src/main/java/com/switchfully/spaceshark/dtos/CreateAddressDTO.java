package com.switchfully.spaceshark.dtos;

public class CreateAddressDTO {

    private String StreetName;
    private String StreetNumber;
    private CreatePostalCodeDTO postalCode;

    public CreateAddressDTO() {
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

    public CreatePostalCodeDTO getPostalCodeDTO() {
        return postalCode;
    }

    public void setPostalCodeDTO(CreatePostalCodeDTO createPostalCodeDTO) {
        this.postalCode = createPostalCodeDTO;
    }

}
