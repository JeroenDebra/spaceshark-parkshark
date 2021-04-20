package com.switchfully.spaceshark.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    @Test
    void givenNullStreet_whenCreatingAddress_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Address(null, "2", "123456", "city"));
    }

    @Test
    void givenNullHouseNumber_whenCreatingAddress_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Address("street", null, "123456", "city"));
    }

    @Test
    void givenNullPostcode_whenCreatingAddress_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Address("street", "2", null, "city"));
    }

    @Test
    void givenNullCity_whenCreatingAddress_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Address("street", "2", "12345", null));
    }

    @Test
    void givenBlankStreet_whenCreatingAddress_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Address(" ", "2", "123456", "city"));
    }

    @Test
    void givenBlankHouseNumber_whenCreatingAddress_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Address("street", " ", "123456", "city"));
    }

    @Test
    void givenBlankPostcode_whenCreatingAddress_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Address("street", "2", " ", "city"));
    }

    @Test
    void givenBlankCity_whenCreatingAddress_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Address("street", "2", "12345", " "));
    }

    @Test
    void givenEmptyStreet_whenCreatingAddress_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Address("", "2", "123456", "city"));
    }

    @Test
    void givenEmptyHouseNumber_whenCreatingAddress_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Address("street", "", "123456", "city"));
    }

    @Test
    void givenEmptyPostcode_whenCreatingAddress_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Address("street", "2", "", "city"));
    }

    @Test
    void givenEmptyCity_whenCreatingAddress_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Address("street", "2", "12345", ""));
    }


}