package com.switchfully.spaceshark.service;

import com.switchfully.spaceshark.model.people.ContactPerson;
import com.switchfully.spaceshark.repositories.ContactPersonRepository;
import org.springframework.stereotype.Service;

@Service
public class ContactPersonService {

    private final ContactPersonRepository contactPersonRepository;

    public ContactPersonService(ContactPersonRepository contactPersonRepository) {
        this.contactPersonRepository = contactPersonRepository;
    }

}
