package com.example.codeclan.pirateservice.repositories;

import com.example.codeclan.pirateservice.models.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {

    //TODO:
    // TASK: Find all the ships with a given pirates first name (William)
    List<Ship> findByPiratesFirstName(String firstName);
}
