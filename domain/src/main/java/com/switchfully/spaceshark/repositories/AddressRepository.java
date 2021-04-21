package com.switchfully.spaceshark.repositories;

import com.switchfully.spaceshark.model.addresses.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
