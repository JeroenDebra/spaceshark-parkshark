package com.switchfully.spaceshark.mappers;

import com.switchfully.spaceshark.customExeptions.CategoryNotValidException;
import com.switchfully.spaceshark.customExeptions.CurrencyNotValidException;
import com.switchfully.spaceshark.dtos.addresses.AddressDto;
import com.switchfully.spaceshark.dtos.addresses.CreateAddressDTO;
import com.switchfully.spaceshark.dtos.contactpersons.ContactPersonDTO;
import com.switchfully.spaceshark.dtos.parkinglots.CreateParkinglotDTO;
import com.switchfully.spaceshark.dtos.parkinglots.ParkinglotDTO;
import com.switchfully.spaceshark.dtos.postalcodes.PostalCodeDTO;
import com.switchfully.spaceshark.model.Price;
import com.switchfully.spaceshark.model.addresses.Address;
import com.switchfully.spaceshark.model.addresses.PostalCode;
import com.switchfully.spaceshark.model.parkingLot.Category;
import com.switchfully.spaceshark.model.parkingLot.Currency;
import com.switchfully.spaceshark.model.parkingLot.Parkinglot;
import com.switchfully.spaceshark.model.people.ContactPerson;
import org.springframework.stereotype.Component;

@Component
public class ParkinglotMapper {

    public Parkinglot createParkinglotDTOToParkinglot(CreateParkinglotDTO createParkinglotDTO){

        Parkinglot parkinglot = new Parkinglot(createParkinglotDTO.getName(),
                stringToCategory(createParkinglotDTO.getCategory()),
                createParkinglotDTO.getMaxCapacity(),
                toPrice(createParkinglotDTO),
                toContactPerson(createParkinglotDTO),
                addressDTOtoAddress(createParkinglotDTO.getAddress()));

        return parkinglot;
    }

    private Address addressDTOtoAddress(CreateAddressDTO addressDTO){
        return new Address(addressDTO.getStreetName(),
                addressDTO.getStreetNumber(),
                new PostalCode(addressDTO.getPostalCodeDTO().getCode(),
                        addressDTO.getPostalCodeDTO().getCity()));
    }

    private ContactPerson toContactPerson(CreateParkinglotDTO createParkinglotDTO){
        return new ContactPerson(createParkinglotDTO.getContactPerson().getName(),
                createParkinglotDTO.getContactPerson().getGsm(),
                createParkinglotDTO.getContactPerson().getPhoneNumber(),
                createParkinglotDTO.getContactPerson().getEmail());
    }

    private Price toPrice(CreateParkinglotDTO createParkinglotDTO){
        return new Price(createParkinglotDTO.getPricePerHour(), stringToCurrency(createParkinglotDTO.getCurrency()));
    }

    private Currency stringToCurrency(String currencyStr){
        try {
            return Currency.valueOf(currencyStr.toUpperCase());
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new CurrencyNotValidException(currencyStr + "is not a valid currency");
        }
    }

    private Category stringToCategory(String categoryStr){
        try {
            return Category.valueOf(categoryStr.toUpperCase());
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new CategoryNotValidException(categoryStr + "is not a valid category");
        }
    }

    public ParkinglotDTO toParkinglotDTO(Parkinglot parkinglot) {
        ParkinglotDTO parkinglotDTO = new ParkinglotDTO()
                .setId(parkinglot.getId())
                .setName(parkinglot.getName())
                .setMaxCapacity(parkinglot.getMaxCapacity())
                .setCategory(parkinglot.getCategory().name())
                .setAddress(addressToAddressDto(parkinglot.getAddress()))
                .setContactPerson(toContactPersonDTO(parkinglot.getContactPerson()))
                .setPricePerHour(parkinglot.getPricePerHour().getPrice())
                .setCurrency(parkinglot.getPricePerHour().getCurrency().name());

        return parkinglotDTO;
    }

    public ContactPersonDTO toContactPersonDTO(ContactPerson contactPerson){
        return new ContactPersonDTO()
                .setId(contactPerson.getId())
                .setName(contactPerson.getName())
                .setGsm(contactPerson.getGsm())
                .setPhoneNumber(contactPerson.getPhoneNumber())
                .setEmail(contactPerson.getEmail());
    }

    public AddressDto addressToAddressDto(Address address){
        return new AddressDto().setStreetName(address.getStreetName()).setStreetNumber(address.getStreetNumber())
                .setPostalCode(postalCodeToPostalCodeDto(address.getPostalCode())).setId(address.getId());
    }

    public PostalCodeDTO postalCodeToPostalCodeDto(PostalCode postalDetails){
        return new PostalCodeDTO().setCode(postalDetails.getCode()).setCity(postalDetails.getCity()).setId(postalDetails.getId());
    }
}
