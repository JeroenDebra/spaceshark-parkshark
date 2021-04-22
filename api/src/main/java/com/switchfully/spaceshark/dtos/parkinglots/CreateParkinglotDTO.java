package com.switchfully.spaceshark.dtos.parkinglots;

import com.switchfully.spaceshark.dtos.addresses.CreateAddressDTO;
import com.switchfully.spaceshark.dtos.contactpersons.CreateContactPersonDTO;

import java.math.BigDecimal;

public class CreateParkinglotDTO {

    private String name;
    private int maxCapacity;
    private String category;
    private CreateAddressDTO address;
    private CreateContactPersonDTO contactPerson;
    private BigDecimal pricePerHour;
    private String currency;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public CreateAddressDTO getAddress() {
        return address;
    }

    public void setAddress(CreateAddressDTO address) {
        this.address = address;
    }

    public CreateContactPersonDTO getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(CreateContactPersonDTO contactPerson) {
        this.contactPerson = contactPerson;
    }

    public BigDecimal getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(BigDecimal pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
