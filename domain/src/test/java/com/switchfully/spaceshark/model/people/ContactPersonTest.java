package com.switchfully.spaceshark.model.people;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactPersonTest {


    String correctEmail = "example@email.com";
    String notCorrectEmail = "exampleemail.com";
    String correctCellPhoneNumber = "+0455555555";
    String correctPhoneNumber = "+016222222";

    @Test
    public void givenValidEmail_WhenCreateContactPerson_ThenCreateContactPersonCorrectly() {
        ContactPerson contactPerson = new ContactPerson("xyz", "+234041234567", "+1234021234578", correctEmail);
        assertEquals("example@email.com", contactPerson.getEmail());
    }

    @Test
    public void givenNonValidEmail_WhenCreateContactPerson_ThenThrowException() {
        assertThrows(IllegalArgumentException.class,
                () -> new ContactPerson("xyz", "+23345041234567", "+2135021234578", notCorrectEmail));
    }

    @Test
    public void givenValidEmail_WhenSettingEmailOfContactPerson_ThenSetEmailOfContactPerson() {
        ContactPerson contactPerson = new ContactPerson();
        contactPerson.setEmail(correctEmail);
        assertEquals(correctEmail, contactPerson.getEmail());
    }

    @Test
    public void givenNonValidEmail_WhenSerttingEmailOfContactPerson_ThenThrowException() {
        assertThrows(IllegalArgumentException.class,
                () -> new ContactPerson().setEmail(notCorrectEmail));
    }

    @Test
    public void givenCorrectGsmNumberAndPhoneNumberNull_whenCreatingContactPerson_CreatesContactPersonCorrectly(){
        ContactPerson contactPerson = new ContactPerson("testname", correctCellPhoneNumber,null,correctEmail);

        assertEquals(correctCellPhoneNumber,contactPerson.getGsm());
        assertNull(contactPerson.getPhoneNumber());
    }

    @Test
    public void givenCorrectPhoneNumberAndCellPhoneNumberNull_whenCreatingContactPerson_CreatesContactPersonCorrectly(){
        ContactPerson contactPerson = new ContactPerson("testname",null,correctPhoneNumber,correctEmail);
        assertEquals(correctPhoneNumber,contactPerson.getPhoneNumber());
        assertNull(contactPerson.getGsm());
    }

    @Test
    public void givenNullGsmAndNullPhoneNumber_WhenCreatingContactPerson_ThrowIllegalArgumentException(){
        assertThrows(IllegalStateException.class,
                () -> new ContactPerson("testname",null,null,correctEmail));
    }

    @Test
    public void Given1CorrectPhoneNumberAnd1IncorrectPhoneNumber_whenCreatingContactPerson_throwsIllegalArgumentException(){
        assertThrows(IllegalArgumentException.class, () -> new ContactPerson("testName", correctCellPhoneNumber,"01impossiblePhoneNumer",correctEmail));
    }


}



