package com.switchfully.spaceshark.model.parkingLot;

import com.switchfully.spaceshark.model.Price;
import com.switchfully.spaceshark.model.addresses.Address;
import com.switchfully.spaceshark.model.people.ContactPerson;

import javax.persistence.*;

@Entity
@Table (name = "parkinglot")
public class Parkinglot {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "name")
    private String name;

    @Column (name = "category")
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column (name = "max_capacity")
    private int maxCapacity;

    @Embedded
    private Price pricePerHour;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "contact_person_id")
    private ContactPerson contactPerson;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "address_id")
    private Address address;


    public Parkinglot(String name, Category category, int maxCapacity, Price pricePerHour, ContactPerson contactPerson, Address address) {
        this.name = name;
        this.category = category;
        this.maxCapacity = maxCapacity;
        this.pricePerHour = pricePerHour;
        this.contactPerson = contactPerson;
        this.address = address;
    }

    public Parkinglot(){

    }

    public Price getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(Price pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public ContactPerson getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(ContactPerson contactPerson) {
        this.contactPerson = contactPerson;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
