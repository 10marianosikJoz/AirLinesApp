package com.example.airlines.service;

import com.example.airlines.model.Flight;
import com.example.airlines.model.Ticket;
import com.example.airlines.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket findTicketByFlight(Flight flight) {
        return ticketRepository.findByFlight(flight).orElseThrow(NoSuchElementException::new);
    }
}
