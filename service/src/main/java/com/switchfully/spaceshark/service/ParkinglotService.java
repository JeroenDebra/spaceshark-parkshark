package com.switchfully.spaceshark.service;

import com.switchfully.spaceshark.model.addresses.Address;
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

    public void save(Parkinglot parkinglot) {
        parkinglotRepository.save(parkinglot);
    }
}
