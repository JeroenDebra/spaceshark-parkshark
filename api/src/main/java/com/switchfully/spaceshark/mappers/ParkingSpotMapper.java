package com.switchfully.spaceshark.mappers;

import com.switchfully.spaceshark.dtos.parkinglots.ParkingSpotDTO;
import com.switchfully.spaceshark.model.parkingallocation.ParkingSpot;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<ParkingSpotDTO> parkingSpotListToParkingSpotDTOList(List<ParkingSpot> allParkingSpots) {
        return allParkingSpots.stream().map(this::parkingSpotToParkingSpotDTO).collect(Collectors.toList());
    }
}
