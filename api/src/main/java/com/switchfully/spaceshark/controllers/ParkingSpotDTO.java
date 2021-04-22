package com.switchfully.spaceshark.controllers;

import com.switchfully.spaceshark.dtos.members.MemberDto;

public class ParkingSpotDTO {

    private int parkingSpotId;
    private MemberDto member;
    private ParkingSpotDTO parkinglot;

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

    public ParkingSpotDTO getParkinglot() {
        return parkinglot;
    }

    public void setParkinglot(ParkingSpotDTO parkinglot) {
        this.parkinglot = parkinglot;
    }
}
