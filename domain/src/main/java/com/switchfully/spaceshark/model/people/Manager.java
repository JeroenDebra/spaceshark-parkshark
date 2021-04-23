package com.switchfully.spaceshark.model.people;

import javax.persistence.*;

@Entity
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;

    public Manager() {
    }

    public Manager(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Manager{" + "Id=" + Id + ", name='" + name + '\'' + ", email='" + email + '\'' + '}';
    }
}
