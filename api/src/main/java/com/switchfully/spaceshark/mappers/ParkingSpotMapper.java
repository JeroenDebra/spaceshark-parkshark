package com.switchfully.spaceshark.mappers;

import com.switchfully.spaceshark.dtos.parkinglots.CreateParkingSpotDTO;
import com.switchfully.spaceshark.dtos.parkinglots.ParkingSpotDTO;
import com.switchfully.spaceshark.model.parkingallocation.ParkingSpot;
import org.springframework.stereotype.Component;

@Component
public class ParkingSpotMapper {
    private final MemberMapper memberMapper;
    private final ParkinglotMapper parkinglotMapper;

    public ParkingSpotMapper(MemberMapper memberMapper, ParkinglotMapper parkinglotMapper) {
        this.memberMapper = memberMapper;
        this.parkinglotMapper = parkinglotMapper;
    }

    public ParkingSpotDTO parkingSpotToParkingSpotDTO(ParkingSpot parkingSpot) {
        ParkingSpotDTO parkingSpotDTO = new ParkingSpotDTO();
        parkingSpotDTO.setParkingSpotId(parkingSpot.getId());
        parkingSpotDTO.setMember(memberMapper.memberToMemberDto(parkingSpot.getMember()));
        parkingSpotDTO.setParkinglot(parkinglotMapper.toParkinglotDTO(parkingSpot.getParkinglot()));
        parkingSpotDTO.setStartTime(parkingSpot.getStartTime());
        return parkingSpotDTO;
    }
}
