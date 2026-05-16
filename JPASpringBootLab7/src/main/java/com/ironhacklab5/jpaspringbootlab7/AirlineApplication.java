package com.ironhacklab5.jpaspringbootlab7;

import com.ironhacklab5.jpaspringbootlab7.entity.Customer;
import com.ironhacklab5.jpaspringbootlab7.entity.CustomerStatus;
import com.ironhacklab5.jpaspringbootlab7.entity.Flight;
import com.ironhacklab5.jpaspringbootlab7.entity.FlightBooking;
import com.ironhacklab5.jpaspringbootlab7.repository.CustomerRepository;
import com.ironhacklab5.jpaspringbootlab7.repository.FlightBookingRepository;
import com.ironhacklab5.jpaspringbootlab7.repository.FlightRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Entry point for the Airline Booking application.
 *
 * The @SpringBootApplication annotation enables:
 *   - @Configuration   (this class can define @Bean methods)
 *   - @EnableAutoConfiguration  (Spring Boot wires JPA, H2, etc. automatically)
 *   - @ComponentScan   (picks up all @Entity, @Repository, @Service classes)
 */
@SpringBootApplication
public class AirlineApplication {

    public static void main(String[] args) {
        SpringApplication.run(AirlineApplication.class, args);
    }

    /**
     * CommandLineRunner runs once after the application context loads.
     * We use it here to seed the database with sample data on startup.
     *
     * Spring injects the three repositories automatically via the method parameters.
     */
    @Bean
    CommandLineRunner run(
            CustomerRepository customerRepo,
            FlightRepository flightRepo,
            FlightBookingRepository bookingRepo) {

        return args -> {

            // ── Seed customers ────────────────────────────────────────
            Customer alice   = customerRepo.save(new Customer("Alice",   CustomerStatus.GOLD,   120_000));
            Customer bob     = customerRepo.save(new Customer("Bob",     CustomerStatus.SILVER,  45_000));
            Customer charlie = customerRepo.save(new Customer("Charlie", CustomerStatus.NONE,     8_200));

            // ── Seed flights ──────────────────────────────────────────
            Flight flight1 = flightRepo.save(new Flight("AB123", "Boeing 747",    300, 400));
            Flight flight2 = flightRepo.save(new Flight("CD456", "Airbus A320",   180, 750));
            Flight flight3 = flightRepo.save(new Flight("EF789", "Boeing 737 MAX",189, 520));

            // ── Seed bookings ─────────────────────────────────────────
            // alice.getId() and flight1.getId() return the DB-generated IDs
            bookingRepo.save(new FlightBooking(alice.getId(),   flight1.getId()));
            bookingRepo.save(new FlightBooking(bob.getId(),     flight2.getId()));
            bookingRepo.save(new FlightBooking(charlie.getId(), flight3.getId()));
            // Extra booking: alice also took flight 2
            bookingRepo.save(new FlightBooking(alice.getId(),   flight2.getId()));

            // ── Demo queries ──────────────────────────────────────────
            System.out.println("\n=== GOLD customers ===");
            customerRepo.findByStatus(CustomerStatus.GOLD)
                    .forEach(System.out::println);

            System.out.println("\n=== Customers with >100,000 miles (bonus) ===");
            customerRepo.findByTotalMilesFlownGreaterThan(100_000)
                    .forEach(System.out::println);

            System.out.println("\n=== Bookings for Alice (id=" + alice.getId() + ") ===");
            bookingRepo.findByCustomerId(alice.getId())
                    .forEach(System.out::println);

            System.out.println("\n=== Bookings on flight AB123 (id=" + flight1.getId() + ") (bonus) ===");
            bookingRepo.findByFlightId(flight1.getId())
                    .forEach(System.out::println);
        };
    }
}
