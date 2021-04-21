package com.switchfully.spaceshark.model.address;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "postal_code")
public class PostalCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "pcode")
    private String postalCode;

    @Column(name = "city")
    private String city;

//    @OneToMany(mappedBy="address")
//    private Set<Address> addressSet;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
