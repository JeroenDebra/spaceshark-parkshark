package com.switchfully.spaceshark.dtos.parkinglots;

import com.switchfully.spaceshark.dtos.members.MemberDTO;

import java.time.LocalDateTime;

public class ParkingSpotDTO {

    private int parkingSpotId;
    private MemberDTO member;
    private ParkinglotDTO parkinglot;
    private LocalDateTime startTime;

    public int getParkingSpotId() {
        return parkingSpotId;
    }

    public void setParkingSpotId(int parkingSpotId) {
        this.parkingSpotId = parkingSpotId;
    }

    public MemberDTO getMember() {
        return member;
    }

    public void setMember(MemberDTO member) {
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
