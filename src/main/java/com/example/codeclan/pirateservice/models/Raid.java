package com.example.codeclan.pirateservice.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity(name = "raids")
public class Raid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String location;

    @Column
    private int loot;

    @JsonBackReference
    @ManyToMany
    // create a JT with name pirates_raids with 2 join columns
    @JoinTable(
            name = "pirates_raids",
            joinColumns = {
                    @JoinColumn(
                            name = "raid_id",
                            nullable = false,
                            updatable = false
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "pirate_id",
                            nullable = false,
                            updatable = false
                    )
            }
    )
    private List<Pirate> pirates;

    public Raid(String location, int loot) {
        this.location = location;
        this.loot = loot;
        this.pirates = new ArrayList<>();
    }

    public Raid() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getLoot() {
        return loot;
    }

    public void setLoot(int loot) {
        this.loot = loot;
    }

    public List<Pirate> getPirates() {
        return pirates;
    }

    public void setPirates(List<Pirate> pirates) {
        this.pirates = pirates;
    }

    public void addPirate(Pirate pirate){
        this.pirates.add(pirate);
    }
}
