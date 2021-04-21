package com.switchfully.spaceshark.model;

import com.switchfully.spaceshark.model.addresses.PostalCode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PostalCodeTest {

    @Test
    void givenNullPostalCode_whenCreatingPostalCode_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new PostalCode(null, "Leuven"));
    }

    @Test
    void givenNullCity_whenCreatingPostalCode_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new PostalCode("123456", null));
    }

    @Test
    void givenBlankPostalCode_whenCreatingPostalCode_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new PostalCode(" ", "Leuven"));
    }

    @Test
    void givenBlankCity_whenCreatingPostalCode_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new PostalCode("123456", " "));
    }

    @Test
    void givenEmptyPostalCode_whenCreatingPostalCode_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new PostalCode("", "Leuven"));
    }

    @Test
    void givenEmptyCity_whenCreatingPostalCode_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new PostalCode("123456", ""));
    }
}
