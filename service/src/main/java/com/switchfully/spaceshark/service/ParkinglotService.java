package com.switchfully.spaceshark.service;

import com.switchfully.spaceshark.model.address.Address;
import com.switchfully.spaceshark.model.parkingLot.Parkinglot;
import com.switchfully.spaceshark.model.people.ContactPerson;
import com.switchfully.spaceshark.repositories.ParkinglotRepository;
import org.springframework.stereotype.Service;

@Service
public class ParkinglotService {

    private final ParkinglotRepository parkinglotRepository;
    private final ContactPersonService contactPersonService;
    private final AddressService addressService;

    public ParkinglotService(ParkinglotRepository parkinglotRepository, ContactPersonService contactPersonService, AddressService addressService) {
        this.parkinglotRepository = parkinglotRepository;
        this.contactPersonService = contactPersonService;
        this.addressService = addressService;
    }

    public void save(Parkinglot parkinglot, int addressId, int contactPersonId) {
        Address address = addressService.addressFindById(addressId);
        ContactPerson contactPerson = contactPersonService.contactPersonFindById(contactPersonId);
        parkinglot.setAddress(address);
        parkinglot.setContactPerson(contactPerson);
        parkinglotRepository.save(parkinglot);
    }
}
