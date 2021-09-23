package com.example.airlines.service;

import com.example.airlines.model.Flight;
import com.example.airlines.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.NoSuchElementException;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }


    public Flight getFlightByProperties(String from,
                                        String destination,
                                        String flightClass,
                                        LocalDate departureDate,
                                        LocalDate returnDate) {
        return flightRepository.findByFromAndDestinationAndFlightClassAndDepartureDateAndReturnDate(from,
                destination,
                flightClass,
                departureDate,
                returnDate).orElseThrow(NoSuchElementException::new);
    }

    public Flight getFlightByFlightNumberAndDepartureDate(String flightNumber, LocalDate departureDate) {
        return flightRepository.findByFlightNumberAndDepartureDate(flightNumber, departureDate).orElseThrow(NoSuchElementException::new);
    }
}
