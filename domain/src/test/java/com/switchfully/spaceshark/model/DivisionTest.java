package com.switchfully.spaceshark.model;

import com.switchfully.spaceshark.model.people.Director;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DivisionTest {

    @Test
    void givenNullDivisionName_whenCreatingDivision_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Division(null, "original", new Director("first", "last")));
    }

    @Test
    void givenNullDivisionOriginalName_whenCreatingDivision_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Division("name", null, new Director("first", "last")));
    }

    @Test
    void givenNullDirector_whenCreatingDivision_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Division("name", "original", null));
    }

    @Test
    void givenBlankDivisionName_whenCreatingDivision_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Division(" ", "original", new Director("first", "last")));
    }

    @Test
    void givenBlankDivisionOriginalName_whenCreatingDivision_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Division("name", " ", new Director("first", "last")));
    }

    @Test
    void givenEmptyDivisionName_whenCreatingDivision_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Division("", "original", new Director("first", "last")));
    }

    @Test
    void givenEmptyDivisionOriginalName_whenCreatingDivision_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Division("name", "", new Director("first", "last")));
    }


}
