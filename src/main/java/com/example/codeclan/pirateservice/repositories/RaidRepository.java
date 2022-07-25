package com.example.codeclan.pirateservice.repositories;

import com.example.codeclan.pirateservice.models.Pirate;
import com.example.codeclan.pirateservice.models.Raid;
import com.example.codeclan.pirateservice.models.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RaidRepository extends JpaRepository<Raid, Long> {

    //TODO: TASK: 10m Write a query to find all the raids for a location
    // * Write a test to check the query works
   // want: List<Raid>
   // have: location: "Tortuga"
   List<Raid> findByLocation(String location);

   // All raids that have pirate with firstName "John"
   // want: List<Raid>
   // have: firstName
   List<Raid> findByPiratesFirstName(String firstName);

   List<Raid> findByPiratesId(Long id);


    // TASK 2: Find all the raids for a given ship  (but a ship object will work, too)
    List<Raid> findByPiratesShip(Ship ship);
}
