package com.ironhacklab5.jpaspringbootlab7.entity;

import jakarta.persistence.*;

/**
 * JPA entity representing an airline customer.
 * Maps to the "customer" table in the database.
 */
@Entity
@Table(name = "customer")
public class Customer {

    // Auto-generated primary key using the database's identity column strategy
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Customer's full name
    private String name;

    /**
     * Loyalty status stored as its string name (e.g. "GOLD")
     * rather than an ordinal integer. Safer and more readable.
     */
    @Enumerated(EnumType.STRING)
    private CustomerStatus status;

    // Cumulative miles the customer has flown across all bookings
    private Integer totalMilesFlown;

    // ─── Constructors ─────────────────────────────────────────────

    // Required by JPA — never call this directly in your own code
    protected Customer() {}

    public Customer(String name, CustomerStatus status, Integer totalMilesFlown) {
        this.name = name;
        this.status = status;
        this.totalMilesFlown = totalMilesFlown;
    }

    // ─── Getters & Setters ────────────────────────────────────────

    public Integer getId()                       { return id; }
    public String getName()                      { return name; }
    public void setName(String name)             { this.name = name; }
    public CustomerStatus getStatus()            { return status; }
    public void setStatus(CustomerStatus status) { this.status = status; }
    public Integer getTotalMilesFlown()          { return totalMilesFlown; }
    public void setTotalMilesFlown(Integer m)    { this.totalMilesFlown = m; }

    @Override
    public String toString() {
        return "Customer{id=" + id + ", name='" + name + "', status=" + status
                + ", totalMilesFlown=" + totalMilesFlown + "}";
    }
}
