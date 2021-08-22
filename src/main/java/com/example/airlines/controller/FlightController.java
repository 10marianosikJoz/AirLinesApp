package com.example.airlines.controller;

import com.example.airlines.dto.FlightDTO;
import com.example.airlines.model.Flight;
import com.example.airlines.service.FlightService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.Duration;

@Controller
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }


    @PostMapping("/available_flights")
    public String availableFlights(@ModelAttribute("flight") FlightDTO flightDTO, Model model) {
        Flight flight = flightService.getFlightByProperties(flightDTO.getFrom(),
                flightDTO.getDestination(),
                flightDTO.getFlightClass(),
                flightDTO.getDepartureDate(),
                flightDTO.getReturnDate());
        model.addAttribute("flight", flight);
        return "available_flights";
    }

    @PostMapping("/flight_status")
    public String checkFlightStatus(@ModelAttribute("flight") FlightDTO flightDTO, Model model) {
        Flight flight = flightService.getFlightByFlightNumber(flightDTO.getFlightNumber());
        model.addAttribute("flight", flight);
        return "flight_status";
    }


}
