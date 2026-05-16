package com.ironhacklab5.jpaspringbootlab7.entity;

import jakarta.persistence.*;

/**
 * JPA entity representing a scheduled flight.
 * Maps to the "flight" table in the database.
 */
@Entity
@Table(name = "flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // IATA-style flight number, e.g. "AB123"
    private String flightNumber;

    // Aircraft model or type, e.g. "Boeing 747"
    private String aircraft;

    // Maximum number of passengers the aircraft can carry
    private Integer totalSeats;

    // Distance of this flight in miles — used for mileage rewards
    private Integer mileage;

    // ─── Constructors ─────────────────────────────────────────────

    protected Flight() {}

    public Flight(String flightNumber, String aircraft, Integer totalSeats, Integer mileage) {
        this.flightNumber = flightNumber;
        this.aircraft = aircraft;
        this.totalSeats = totalSeats;
        this.mileage = mileage;
    }

    // ─── Getters & Setters ────────────────────────────────────────

    public Integer getId()                      { return id; }
    public String getFlightNumber()             { return flightNumber; }
    public void setFlightNumber(String fn)      { this.flightNumber = fn; }
    public String getAircraft()                 { return aircraft; }
    public void setAircraft(String aircraft)    { this.aircraft = aircraft; }
    public Integer getTotalSeats()              { return totalSeats; }
    public void setTotalSeats(Integer seats)    { this.totalSeats = seats; }
    public Integer getMileage()                 { return mileage; }
    public void setMileage(Integer mileage)     { this.mileage = mileage; }

    @Override
    public String toString() {
        return "Flight{id=" + id + ", flightNumber='" + flightNumber + "', aircraft='"
                + aircraft + "', totalSeats=" + totalSeats + ", mileage=" + mileage + "}";
    }
}