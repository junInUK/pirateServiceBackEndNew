package com.example.codeclan.pirateservice.repositories;

import com.example.codeclan.pirateservice.models.Pirate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// @Repository means that spring will create a new instance of PirateRepository for us
@Repository   // this asks spring to create ONE instance of this for us to re-use
public interface PirateRepository extends JpaRepository<Pirate, Long> {

    List<Pirate> findByFirstName(String firstName);


    // operation[distinct][<Class>]By<property>[comparison][<operator>] * where:
    // find              ByAge        And        FirstName
    //  get
    // read
    // count             ByAge

    // find all the pirates aged 33
    // Want: List<Pirate>
    // Have: age 33 (int)
    List<Pirate> findByAge(int age);



    // count all the pirates with the last name "silver"
    // want number int
    // have lastName: "Silver"
    int countByLastName(String lastName);

    // find pirates by firstName OR lastName
    // want: List<Pirate>
    List<Pirate> findByFirstNameOrLastName(String firstName, String lastName);



    List<Pirate> findByAgeGreaterThan(int age);

    Pirate findDistinctPiratesByName(String name);

}
