package com.switchfully.spaceshark.dtos.parkinglots;

import com.switchfully.spaceshark.dtos.addresses.AddressDto;
import com.switchfully.spaceshark.dtos.contactpersons.ContactPersonDTO;

import java.math.BigDecimal;

public class ParkinglotDTO {

    private int id;
    private String name;
    private int maxCapacity;
    private String category;
    private AddressDto address;
    private ContactPersonDTO contactPerson;
    private BigDecimal pricePerHour;
    private String currency;

    public int getId() {
        return id;
    }

    public ParkinglotDTO setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ParkinglotDTO setName(String name) {
        this.name = name;
        return this;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public ParkinglotDTO setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public ParkinglotDTO setCategory(String category) {
        this.category = category;
        return this;
    }

    public AddressDto getAddress() {
        return address;
    }

    public ParkinglotDTO setAddress(AddressDto address) {
        this.address = address;
        return this;
    }

    public ContactPersonDTO getContactPerson() {
        return contactPerson;
    }

    public ParkinglotDTO setContactPerson(ContactPersonDTO contactPerson) {
        this.contactPerson = contactPerson;
        return this;
    }

    public BigDecimal getPricePerHour() {
        return pricePerHour;
    }

    public ParkinglotDTO setPricePerHour(BigDecimal pricePerHour) {
        this.pricePerHour = pricePerHour;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public ParkinglotDTO setCurrency(String currency) {
        this.currency = currency;
        return this;
    }
}
