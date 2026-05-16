package com.ironhacklab5.jpaspringbootlab7.entity;

import jakarta.persistence.*;

/**
 * JPA entity representing a booking — the link between a customer
 * and a specific flight.
 *
 * Note: We intentionally store customerId and flightId as raw
 * Integer fields (not @ManyToOne relationships). This keeps things
 * simple for now; entity relationships will be introduced later.
 */
@Entity
@Table(name = "flight_booking")
public class FlightBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Foreign key referencing the Customer table (stored as a plain field)
    private Integer customerId;

    // Foreign key referencing the Flight table (stored as a plain field)
    private Integer flightId;

    // ─── Constructors ─────────────────────────────────────────────

    protected FlightBooking() {}

    public FlightBooking(Integer customerId, Integer flightId) {
        this.customerId = customerId;
        this.flightId = flightId;
    }

    // ─── Getters & Setters ────────────────────────────────────────

    public Integer getId()                    { return id; }
    public Integer getCustomerId()            { return customerId; }
    public void setCustomerId(Integer cid)    { this.customerId = cid; }
    public Integer getFlightId()              { return flightId; }
    public void setFlightId(Integer fid)      { this.flightId = fid; }

    @Override
    public String toString() {
        return "FlightBooking{id=" + id + ", customerId=" + customerId
                + ", flightId=" + flightId + "}";
    }
}
