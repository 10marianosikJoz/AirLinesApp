package com.example.airlines.controller;

import com.example.airlines.dto.FlightDTO;
import com.example.airlines.model.Flight;
import com.example.airlines.service.FlightService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Controller
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }



    @GetMapping("/available_flights")
    public String availableFlights(@ModelAttribute("flight") FlightDTO flightDTO, Model model) {
        List<Flight> flights = flightService.getFlights();
        flightDTO.setFrom("London");
        flightDTO.setDestination("Miami");
        flightDTO.setFlightClass("Bus");
        flightDTO.setArrivalTime(LocalTime.of(12,33,11));
        flightDTO.setDepartureTime(LocalTime.of(12,11,11));
        flightDTO.setReturnDate(LocalDate.of(2021,11,27));
        flightDTO.setDepartureDate(LocalDate.of(2021,11,22));
        flightDTO.setFlightNumber("11");
        Flight flight = flightService.getFlightByProperties(flightDTO.getFrom(),
                flightDTO.getDestination(),
                flightDTO.getFlightClass(),
                flightDTO.getDepartureDate(),
                flightDTO.getReturnDate());

        model.addAttribute("flight", flight);
        model.addAllAttributes(flights);
        return "available_flights";
    }


}
