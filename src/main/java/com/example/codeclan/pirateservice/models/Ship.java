package com.example.codeclan.pirateservice.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ships")
public class Ship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @JsonBackReference
    @OneToMany(mappedBy = "ship")
    private List<Pirate> pirates;

    public Ship(String name) {
        this.name = name;
        this.pirates = new ArrayList<>();
    }

    public Ship(Long id){
        this.id = id;
    }

    public Ship() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pirate> getPirates() {
        return pirates;
    }

    public void setPirates(List<Pirate> pirates) {
        this.pirates = pirates;
    }


}
