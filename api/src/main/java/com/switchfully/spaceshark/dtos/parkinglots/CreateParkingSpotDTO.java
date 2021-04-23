package com.switchfully.spaceshark.dtos.parkinglots;

import java.time.LocalDateTime;

public class CreateParkingSpotDTO {

    private int memberId;
    private int parkinglotId;
    private String licensePlate;
    private LocalDateTime startTime;

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getParkinglotId() {
        return parkinglotId;
    }

    public void setParkinglotId(int parkinglotId) {
        this.parkinglotId = parkinglotId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return "CreateParkingSpotDTO{" +
                "memberId=" + memberId +
                ", parkinglotId=" + parkinglotId +
                ", licensePlate='" + licensePlate + '\'' +
                ", startTime=" + startTime +
                '}';
    }
}
