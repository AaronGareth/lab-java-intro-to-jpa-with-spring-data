package com.ironhacklab5.jpaspringbootlab7.repository;

import com.ironhacklab5.jpaspringbootlab7.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for Flight entities.
 *
 * Inherits all standard CRUD operations from JpaRepository.
 * No custom query methods needed for the mandatory tasks,
 * but you can add them here as the system grows.
 */
public interface FlightRepository extends JpaRepository<Flight, Integer> {
    // Standard CRUD from JpaRepository is sufficient for now
}
