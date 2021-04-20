package com.switchfully.spaceshark.dto;

public class DivisionDTO {

    private int id;
    private String name;
    private String originalName;
    private String directorFirstname;
    private String directorLastname;

    public int getId() {
        return id;
    }

    public DivisionDTO setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public DivisionDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getOriginalName() {
        return originalName;
    }

    public DivisionDTO setOriginalName(String originalName) {
        this.originalName = originalName;
        return this;
    }

    public String getDirectorFirstname() {
        return directorFirstname;
    }

    public DivisionDTO setDirectorFirstname(String directorFirstname) {
        this.directorFirstname = directorFirstname;
        return this;
    }

    public String getDirectorLastname() {
        return directorLastname;
    }

    public DivisionDTO setDirectorLastname(String directorLastname) {
        this.directorLastname = directorLastname;
        return this;
    }
}
