package com.switchfully.spaceshark.repositories;

import com.switchfully.spaceshark.model.people.ContactPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactPersonRepository extends JpaRepository<ContactPerson, Integer> {
}
