package com.switchfully.spaceshark.dtos.divisions;

public class CreateDivisionDTO {

    private String name;
    private String originalName;
    private String director_firstname;
    private String director_lastname;

    public CreateDivisionDTO() {
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

    public String getDirector_firstname() {
        return director_firstname;
    }

    public void setDirector_firstname(String director_firstname) {
        this.director_firstname = director_firstname;
    }

    public String getDirector_lastname() {
        return director_lastname;
    }

    public void setDirector_lastname(String director_lastname) {
        this.director_lastname = director_lastname;
    }
}
