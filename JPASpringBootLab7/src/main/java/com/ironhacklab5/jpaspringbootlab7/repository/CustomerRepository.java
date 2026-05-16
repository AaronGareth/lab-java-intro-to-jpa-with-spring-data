package com.ironhacklab5.jpaspringbootlab7.repository;

import com.ironhacklab5.jpaspringbootlab7.entity.Customer;
import com.ironhacklab5.jpaspringbootlab7.entity.CustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository for Customer entities.
 *
 * Extends JpaRepository<Customer, Integer> which gives us:
 *   save(), findById(), findAll(), deleteById(), count(), etc.
 *
 * Spring Data JPA generates the SQL for derived query methods
 * automatically — no implementation needed.
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    /**
     * Find all customers with a specific loyalty status.
     * Generated SQL: SELECT * FROM customer WHERE status = ?
     *
     * @param status the loyalty tier to filter by (GOLD, SILVER, or NONE)
     * @return a list of matching customers
     */
    List<Customer> findByStatus(CustomerStatus status);

    // ─── Bonus ────────────────────────────────────────────────────

    /**
     * Find customers whose total mileage exceeds a given threshold.
     * Generated SQL: SELECT * FROM customer WHERE total_miles_flown > ?
     *
     * @param miles the minimum mileage (exclusive)
     * @return a list of high-mileage customers
     */
    List<Customer> findByTotalMilesFlownGreaterThan(Integer miles);
}
