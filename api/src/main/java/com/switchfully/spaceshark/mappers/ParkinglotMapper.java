package com.switchfully.spaceshark.mappers;

import com.switchfully.spaceshark.dtos.CreateParkinglotDTO;
import com.switchfully.spaceshark.model.addresses.Address;
import com.switchfully.spaceshark.model.addresses.PostalCode;
import com.switchfully.spaceshark.model.parkingLot.Parkinglot;
import com.switchfully.spaceshark.model.people.ContactPerson;
import org.springframework.stereotype.Component;

@Component
public class ParkinglotMapper {

    public Parkinglot toParkinglot(CreateParkinglotDTO createParkinglotDTO){

        Parkinglot parkinglot = new Parkinglot(createParkinglotDTO.getName(),
                createParkinglotDTO.getCategory(),
                createParkinglotDTO.getMaxCapacity(),
                toContactPerson(createParkinglotDTO),
                toAddress(createParkinglotDTO));

        return parkinglot;
    }

    public Address toAddress(CreateParkinglotDTO createParkinglotDTO){
        return new Address(createParkinglotDTO.getAddress().getStreetName(),
                createParkinglotDTO.getAddress().getStreetNumber(),
                new PostalCode(createParkinglotDTO.getAddress().getPostalCodeDTO().getPostalCode(),
                        createParkinglotDTO.getAddress().getPostalCodeDTO().getCity()));
    }

    public ContactPerson toContactPerson(CreateParkinglotDTO createParkinglotDTO){
        return new ContactPerson(createParkinglotDTO.getContactPerson().getName(),
                createParkinglotDTO.getContactPerson().getGsm(),
                createParkinglotDTO.getContactPerson().getPhoneNumber(),
                createParkinglotDTO.getContactPerson().getEmail());
    }

}
