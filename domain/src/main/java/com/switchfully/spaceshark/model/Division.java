package com.switchfully.spaceshark.model;

import com.switchfully.spaceshark.model.people.Director;
import com.switchfully.spaceshark.utils.ValidationUtil;

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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "director_id" )
    private Director director;

    public Division() {
    }

    public Division( String name, String originalName, Director director) {
        ValidationUtil.throwExceptionIfNullOrEmptyOrBlank(name, "division name");
        ValidationUtil.throwExceptionIfNullOrEmptyOrBlank(originalName, "division original name");
        ValidationUtil.throwExceptionIfNullObject(director, "director object");
        this.name = name;
        this.originalName = originalName;
        this.director = director;
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

    @Override
    public String toString() {
        return "Division{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", originalName='" + originalName + '\'' +
                ", director=" + director +
                '}';
    }
}
