package com.switchfully.spaceshark.dtos.parkinglots;

public class OverviewParkinglotDTO {

    private int id;
    private String name;
    private int maxCapacity;
    private String email;
    private String gsm;
    private String phone;

    public int getId() {
        return id;
    }

    public OverviewParkinglotDTO setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public OverviewParkinglotDTO setName(String name) {
        this.name = name;
        return this;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public OverviewParkinglotDTO setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public OverviewParkinglotDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getGsm() {
        return gsm;
    }

    public OverviewParkinglotDTO setGsm(String gsm) {
        this.gsm = gsm;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public OverviewParkinglotDTO setPhone(String phone) {
        this.phone = phone;
        return this;
    }
}
