package com.example.codeclan.pirateservice.controllers;

import com.example.codeclan.pirateservice.models.Pirate;
import com.example.codeclan.pirateservice.models.Raid;
import com.example.codeclan.pirateservice.repositories.PirateRepository;
import com.example.codeclan.pirateservice.repositories.RaidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PirateController {

    @Autowired
    PirateRepository pirateRepository;

    @Autowired
    RaidRepository raidRepository;

    /**
     * This controller allows us to do:
     * GET /pirates returning [] of all the pirates
     * GET /pirates?firstName=John returning just pirates named John
     * GET /pirate?age=3 returning all pirates age 3
     * @return
     */
    @GetMapping(value = "/pirates")
    public ResponseEntity<List<Pirate>> getAllPirates(
            @RequestParam(name="firstName", required = false) String firstName,
            @RequestParam(name="age", required = false) Integer age
    ) {
        // the one where we find all the pirates:
        if (firstName != null){
            // the one where we find all the pirates with given firstname
            return new ResponseEntity<>(pirateRepository.findByFirstName(firstName), HttpStatus.OK);
        }

        if (age != null){
            return new ResponseEntity<>(pirateRepository.findByAge(age), HttpStatus.OK);
        }

        List<Pirate> foundPirates = pirateRepository.findAll(); // just returns a normal Java List<Pirate>
        return new ResponseEntity<List<Pirate>>(foundPirates, HttpStatus.OK);
    }


    @GetMapping(value = "/pirates/{id}")
    public ResponseEntity getPirate(@PathVariable Long id){
        return new ResponseEntity<>(pirateRepository.findById(id), HttpStatus.OK);
    }

//    @GetMapping(value = "/pirates/{id}/raids")
//    public ResponseEntity getPirateRaids(@PathVariable Long id){
//        List<Raid> foundRaids = raidRepository.findByPiratesId(id);
//        return new ResponseEntity<List<Raid>>(foundRaids, HttpStatus.OK);
//    }

    @GetMapping(value = "/pirates/firstName={firstName}")
    public ResponseEntity getPirateByFirstName(@PathVariable String firstName) {
        return new ResponseEntity(pirateRepository.findDistinctPiratesByName(firstName), HttpStatus.OK);
    }

    @PostMapping(value = "/pirates")
    public ResponseEntity<Pirate> postPirate(@RequestBody Pirate pirate){
        pirateRepository.save(pirate);
        return new ResponseEntity<>(pirate, HttpStatus.CREATED);
    }

    @PutMapping(value = "/pirates/{id}")  // HTTP API version of an UPDATE
    public ResponseEntity<Pirate> putPirate(@RequestBody Pirate pirate, @PathVariable Long id){
        if (pirate.getId().longValue() != id){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // response entity with no body
        }
        // get the pirate with the given id
        // save the new pirate body
        pirateRepository.save(pirate);
        return new ResponseEntity<>(pirate, HttpStatus.CREATED);
    }


    @DeleteMapping(value = "/pirates/{id}")
    public ResponseEntity<List<Pirate>> deletePirate(@PathVariable Long id){
        pirateRepository.deleteById(id);
        return new ResponseEntity<>(pirateRepository.findAll(), HttpStatus.OK);
    }



}
