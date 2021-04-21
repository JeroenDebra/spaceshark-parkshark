package com.switchfully.spaceshark.repositories;


import com.switchfully.spaceshark.model.parkingLots.Parkinglot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkinglotRepository extends JpaRepository<Parkinglot, Integer> {
}


