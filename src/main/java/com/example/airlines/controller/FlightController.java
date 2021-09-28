package com.example.airlines.controller;

import com.example.airlines.dto.FlightDTO;
import com.example.airlines.model.Flight;
import com.example.airlines.model.Ticket;
import com.example.airlines.service.FlightService;
import com.example.airlines.service.TicketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FlightController {

    private final FlightService flightService;
    private final TicketService ticketService;

    public FlightController(FlightService flightService, TicketService ticketService) {
        this.flightService = flightService;
        this.ticketService = ticketService;
    }


    @PostMapping("/available_flights")
    public String availableFlights(@ModelAttribute("flight") FlightDTO flightDTO, Model model) {
        Flight flight = flightService.findFlightByBasicData(flightDTO.getFrom(),
                flightDTO.getDestination(),
                flightDTO.getFlightClass(),
                flightDTO.getDepartureDate(),
                flightDTO.getReturnDate());
        model.addAttribute("flight", flight);
        return "available_flights";
    }

    @PostMapping("/flight_status")
    public String checkFlightStatus(@ModelAttribute("flight") FlightDTO flightDTO, Model model) {
        Flight flight = flightService.getFlightByFlightNumberAndDepartureDate(flightDTO.getFlightNumber(), flightDTO.getDepartureDate());
        Ticket ticket = ticketService.findTicketByFlight(flight);
        model.addAttribute("flight", flight);
        model.addAttribute("ticket", ticket);
        return "flight_status";
    }


}
