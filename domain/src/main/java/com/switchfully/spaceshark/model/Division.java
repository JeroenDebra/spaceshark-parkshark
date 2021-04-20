package com.switchfully.spaceshark.model;

import javax.persistence.*;

@Entity
@Table(name = "divisions")
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;
    @Column(name = "original_name")
    private String originalName;
    @OneToOne
    @JoinColumn(name = "director_id" )
    private Director director;


    public Division() {
    }

    public Division( String name, String originalName, Director director) {
        this.name = name;
        this.originalName = originalName;
        this.director = director;
    }

    public Division(String name, String originalName) {
        this.name = name;
        this.originalName = originalName;
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

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }
}
