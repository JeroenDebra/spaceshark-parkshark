package com.switchfully.spaceshark.repositories;

import com.switchfully.spaceshark.model.parkingLot.Parkinglot;
import com.switchfully.spaceshark.model.parkingallocation.ParkingSpot;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpot,Integer> {

    List<ParkingSpot> findAllByParkinglot(Parkinglot parkinglot);
    List<ParkingSpot> getParkingSpotsByIdIsGreaterThanOrderByStartTimeAsc(Integer id);


}
