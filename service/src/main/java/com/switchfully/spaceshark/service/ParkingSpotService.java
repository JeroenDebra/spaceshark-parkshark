package com.switchfully.spaceshark.service;

import com.switchfully.spaceshark.model.parkingLot.Parkinglot;
import com.switchfully.spaceshark.model.parkingallocation.ParkingSpot;
import com.switchfully.spaceshark.model.people.Member;
import com.switchfully.spaceshark.repositories.ParkingSpotRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class ParkingSpotService {

    private static final Logger logger = LoggerFactory.getLogger(MemberService.class);

    private final ParkingSpotRepository parkingSpotRepository;
    private final ParkinglotService parkinglotService;
    private final MemberService memberService;

    public ParkingSpotService(ParkingSpotRepository parkingSpotRepository, ParkinglotService parkinglotService, MemberService memberService) {
        this.parkingSpotRepository = parkingSpotRepository;
        this.parkinglotService = parkinglotService;
        this.memberService = memberService;
    }

    public ParkingSpot createParkingSpot(int parkingLotId, int memberId, LocalDateTime startTime, String licencePlate) {
        Parkinglot parkinglot = parkinglotService.findParkinglotById(parkingLotId);
        Member member = memberService.findMemberById(memberId);

        if (parkinglot.getMaxCapacity() <= parkingSpotRepository.findAllByParkinglot(parkinglot).size()) {
            logger.warn("parking spot for member: " + memberId + " could not be created because parkinglot " + parkingLotId + "is full." );
            throw new IllegalStateException("cant add parkingspot because parking lot is full");
        }

        if (!member.getLicencePlate().equals(licencePlate)) {
            logger.warn("parking spot for member: " + memberId + " could not be created because licence plate " + licencePlate + " is not correct.");
            throw new IllegalArgumentException("Licence plate does not belong to the member: \n" + member);
        }

        ParkingSpot parkingSpot = new ParkingSpot();
        parkingSpot.setParkinglot(parkinglot);
        parkingSpot.setMember(member);
        parkingSpot.setStartTime(startTime);

        return parkingSpotRepository.save(parkingSpot);

    }

    public List<ParkingSpot> getAllParkingSpots() {
        return parkingSpotRepository.findAll();
    }
}
