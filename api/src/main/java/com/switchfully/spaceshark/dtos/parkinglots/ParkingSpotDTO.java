package com.switchfully.spaceshark.dtos.parkinglots;

import com.switchfully.spaceshark.dtos.members.MemberDto;

import java.time.LocalDateTime;

public class ParkingSpotDTO {

    private int parkingSpotId;
    private MemberDto member;
    private ParkinglotDTO parkinglot;
    private LocalDateTime startTime;

    public int getParkingSpotId() {
        return parkingSpotId;
    }

    public void setParkingSpotId(int parkingSpotId) {
        this.parkingSpotId = parkingSpotId;
    }

    public MemberDto getMember() {
        return member;
    }

    public void setMember(MemberDto member) {
        this.member = member;
    }

    public ParkinglotDTO getParkinglot() {
        return parkinglot;
    }

    public void setParkinglot(ParkinglotDTO parkinglot) {
        this.parkinglot = parkinglot;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
}
