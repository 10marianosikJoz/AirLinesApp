package com.example.airlines.repository;

import com.example.airlines.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {


    Optional<Flight> findByFromAndDestinationAndFlightClassAndDepartureDateAndReturnDate(String from,
                                                                                         String destination,
                                                                                         String flightClass,
                                                                                         LocalDate departureDate, LocalDate returnDate);

    Optional<Flight> findByFlightNumberAndDepartureDate(String flightNumber, LocalDate departureDate);
}
