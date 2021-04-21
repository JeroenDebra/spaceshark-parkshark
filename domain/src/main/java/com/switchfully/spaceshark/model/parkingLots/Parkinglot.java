package com.switchfully.spaceshark.model.parkingLots;

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
    private String category;

    @Column (name = "max_capacity")
    private int maxCapacity;

    @ManyToOne()
    @JoinColumn(name = "contact_person_id")
    private ContactPerson contactPerson;

    @ManyToOne()
    @JoinColumn(name = "address_id")
    private Address address;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
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

    public Parkinglot(String name, String category, int maxCapacity) {
        this.name = name;
        this.category = category;
        this.maxCapacity = maxCapacity;
    }

    public Parkinglot(){

    }
}
