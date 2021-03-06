package com.switchfully.spaceshark.model.people;

import com.switchfully.spaceshark.model.addresses.Address;
import com.switchfully.spaceshark.model.addresses.PostalCode;
import com.switchfully.spaceshark.model.people.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MemberTest {

    @Test
    void givenNullMemberFirstName_whenCreatingMember_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Member(null, "nitro",
                        new Address("street", "2", new PostalCode("123456", "city")), "123456789", "jeannie@nitro.io", "BE123" ));
    }

    @Test
    void givenNullMemberLastName_whenCreatingMember_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Member("jeannie", null,
                new Address("street", "2", new PostalCode("123456", "city")), "123456789", "jeannie@nitro.io", "BE123" ));
    }

    @Test
    void givenNullMemberLicencePlate_whenCreatingMember_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Member("jeannie", "nitro",
                new Address("street", "2", new PostalCode("123456", "city")), "123456789", "jeannie@nitro.io", null ));
    }

    @Test
    void givenNullMemberPhoneNumber_whenCreatingMember_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Member("jeannie", "nitro",
                new Address("street", "2", new PostalCode("123456", "city")), null, "jeannie@nitro.io", "BE123" ));
    }

    @Test
    void givenNullMemberEmail_whenCreatingMember_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Member("jeannie", "nitro",
                new Address("street", "2", new PostalCode("123456", "city")), "123456789", null, "BE123" ));
    }

    @Test
    void givenNullMemberAddress_whenCreatingMember_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Member("jeannie", "nitro",
                null, "123456789", "jeannie@nitro.io", "BE123" ));
    }

    @Test
    void givenBlankMemberFirstName_whenCreatingMember_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Member(" ", "nitro",
                new Address("street", "2", new PostalCode("123456", "city")), "123456789", "jeannie@nitro.io", "BE123" ));
    }

    @Test
    void givenBlankMemberLastName_whenCreatingMember_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Member("jeannie", " ",
                new Address("street", "2", new PostalCode("123456", "city")), "123456789", "jeannie@nitro.io", "BE123" ));
    }

    @Test
    void givenBlankMemberLicencePlate_whenCreatingMember_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Member("jeannie", "nitro",
                new Address("street", "2", new PostalCode("123456", "city")), "123456789", "jeannie@nitro.io", " " ));
    }

    @Test
    void givenBlankMemberPhoneNumber_whenCreatingMember_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Member("jeannie", "nitro",
                new Address("street", "2", new PostalCode("123456", "city")), " ", "jeannie@nitro.io", "BE123" ));
    }

    @Test
    void givenBlankMemberEmail_whenCreatingMember_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Member("jeannie", "nitro",
                new Address("street", "2", new PostalCode("123456", "city")), "123456789", " ", "BE123" ));
    }

    @Test
    void givenEmptyMemberFirstName_whenCreatingMember_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Member("", "nitro",
                new Address("street", "2", new PostalCode("123456", "city")), "123456789", "jeannie@nitro.io", "BE123" ));
    }

    @Test
    void givenEmptyMemberLastName_whenCreatingMember_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Member("jeannie", "",
                new Address("street", "2", new PostalCode("123456", "city")), "123456789", "jeannie@nitro.io", "BE123" ));
    }

    @Test
    void givenEmptyMemberLicencePlate_whenCreatingMember_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Member("jeannie", "nitro",
                new Address("street", "2", new PostalCode("123456", "city")), "123456789", "jeannie@nitro.io", "" ));
    }

    @Test
    void givenEmptyMemberPhoneNumber_whenCreatingMember_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Member("jeannie", "nitro",
                new Address("street", "2", new PostalCode("123456", "city")), "", "jeannie@nitro.io", "BE123" ));
    }

    @Test
    void givenEmptyMemberEmail_whenCreatingMember_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Member("jeannie", "nitro",
                new Address("street", "2", new PostalCode("123456", "city")), "123456789", "", "BE123" ));
    }

}
