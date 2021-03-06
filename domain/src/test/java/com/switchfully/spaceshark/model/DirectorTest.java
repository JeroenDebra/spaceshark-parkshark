package com.switchfully.spaceshark.model;

import com.switchfully.spaceshark.model.people.Director;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DirectorTest {

    @Test
    void givenNullDirectorFirstName_whenCreatingDirector_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Director(null, "last"));
    }

    @Test
    void givenNullDirectorLastName_whenCreatingDirector_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Director("first", null));
    }

    @Test
    void givenBlankDirectorFirstName_whenCreatingDirector_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Director(" ", "last"));
    }

    @Test
    void givenBlankDirectorLastName_whenCreatingDirector_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Director("first", " "));
    }

    @Test
    void givenEmptyDirectorFirstName_whenCreatingDirector_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Director("", "last"));
    }

    @Test
    void givenEmptyDirectorLastName_whenCreatingDirector_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Director("first", ""));
    }


}
