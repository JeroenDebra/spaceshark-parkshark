package com.switchfully.spaceshark.service;

import com.switchfully.spaceshark.model.addresses.Address;
import com.switchfully.spaceshark.repositories.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address addressFindById (int addressId){
        return addressRepository.findById(addressId).get();
    }
}
