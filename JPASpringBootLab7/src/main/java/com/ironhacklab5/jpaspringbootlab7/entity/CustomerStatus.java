package com.ironhacklab5.jpaspringbootlab7.entity;


/**
 * Enum representing the loyalty tier of a customer.
 * Used with @Enumerated(EnumType.STRING) so the database
 * stores the name (e.g. "GOLD") instead of an integer index.
 * This makes the data readable and safe if enum order changes.
 */
public enum CustomerStatus {
    GOLD,
    SILVER,
    NONE
}