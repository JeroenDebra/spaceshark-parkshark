package com.switchfully.spaceshark.model;

import com.switchfully.spaceshark.model.addresses.Address;
import com.switchfully.spaceshark.model.addresses.PostalCode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AddressTest {

    @Test
    void givenNullStreet_whenCreatingAddress_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Address(null, "2", new PostalCode("1235", "Leuven")));
    }

    @Test
    void givenNullHouseNumber_whenCreatingAddress_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Address("street", null, new PostalCode("1235", "Leuven")));
    }

    @Test
    void givenNullPostcode_whenCreatingAddress_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Address(null, "2", null));
    }

    @Test
    void givenBlankStreet_whenCreatingAddress_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Address(" ", "2", new PostalCode("1235", "Leuven")));
    }

    @Test
    void givenBlankHouseNumber_whenCreatingAddress_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Address("street", " ", new PostalCode("1235", "Leuven")));
    }

    @Test
    void givenEmptyStreet_whenCreatingAddress_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Address("", "2", new PostalCode("1235", "Leuven")));
    }

    @Test
    void givenEmptyHouseNumber_whenCreatingAddress_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Address("street", "", new PostalCode("1235", "Leuven")));
    }

}
