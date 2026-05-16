package com.ironhacklab5.jpaspringbootlab7.repository;

import com.ironhacklab5.jpaspringbootlab7.entity.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository for FlightBooking entities.
 *
 * Provides query methods for looking up bookings
 * by customer or by flight.
 */
public interface FlightBookingRepository extends JpaRepository<FlightBooking, Integer> {

    /**
     * Find all bookings made by a specific customer.
     * Generated SQL: SELECT * FROM flight_booking WHERE customer_id = ?
     *
     * @param customerId the ID of the customer
     * @return list of that customer's bookings
     */
    List<FlightBooking> findByCustomerId(Integer customerId);

    // ─── Bonus ────────────────────────────────────────────────────

    /**
     * Find all bookings on a specific flight.
     * Generated SQL: SELECT * FROM flight_booking WHERE flight_id = ?
     *
     * @param flightId the ID of the flight
     * @return list of bookings on that flight
     */
    List<FlightBooking> findByFlightId(Integer flightId);
}
