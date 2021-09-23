package com.example.airlines.service;

import com.example.airlines.model.Flight;
import com.example.airlines.repository.FlightRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.NoSuchElementException;

import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class FlightServiceTest {

    @MockBean
    FlightRepository flightRepository;

    @MockBean
    FlightService flightService;

    private final String from = "London";
    private final String destination = "Miami";
    private final String flightClass = "Bus";
    private final LocalDate departureDate = LocalDate.of(2021,11,22);
    private final LocalDate returnDate = LocalDate.of(2021,11,27);


    @Test
    void find_flight_by_from_destination_departure_arrival() {
        //given
        Flight flight = new Flight();
        //when
        flight.setFrom("London");
        flight.setDestination("Miami");
        flight.setDepartureDate(LocalDate.of(2021,11,22));
        flight.setReturnDate(LocalDate.of(2021,11,27));
        //then
        when(flightService.getFlightByProperties(from,destination,flightClass,departureDate,returnDate)).thenReturn(flight);

    }

    @Test
    void should_throw_exception_when_flight_is_not_present() {
        //given
        Flight flight = new Flight();
        //when
        flight.setFrom("London");
        flight.setDestination("Warsaw");
        flight.setDepartureDate(LocalDate.of(2021,11,22));
        flight.setReturnDate(LocalDate.of(2021,11,27));
        //then
        when(flightService.getFlightByProperties(from,destination,flightClass,departureDate,returnDate)).thenThrow(new NoSuchElementException("Flight doesn't exist"));
    }
}
