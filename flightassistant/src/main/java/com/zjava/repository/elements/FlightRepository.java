package com.zjava.repository.elements;

import com.zjava.model.elements.Flight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Adrian on 2017-06-18.
 */
@Repository
public interface FlightRepository extends CrudRepository<Flight, Long> {
    Flight save(Flight flight);

    List<Flight> findAll();

    Flight findOne(Long id);

    boolean exists(Long id);

    long count();

    void delete(Long id);

    void deleteAll();
}