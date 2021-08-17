package com.example.airlines.mapper;

import com.example.airlines.dto.FlightDTO;
import com.example.airlines.model.Flight;
import org.modelmapper.ModelMapper;

public class FlightMapper {

    private final ModelMapper modelMapper;

    public FlightMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public FlightDTO convertToFlightDto(Flight flight) {
        FlightDTO flightDTO = modelMapper.map(flight, FlightDTO.class);
        flightDTO.setFrom(flight.getFrom());
        flightDTO.setDestination(flight.getDestination());
        flightDTO.setDepartureDate(flight.getDepartureDate());
        flightDTO.setReturnDate(flight.getReturnDate());
        flightDTO.setDepartureTime(flight.getDepartureTime());
        flightDTO.setArrivalTime(flight.getArrivalTime());
        flightDTO.setFlightClass(flight.getFlightClass());
        return flightDTO;
    }
}
