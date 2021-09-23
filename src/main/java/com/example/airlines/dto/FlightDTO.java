package com.example.airlines.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;


public class FlightDTO {


    private String from;
    private String destination;
    private String flightClass;
    private LocalDate departureDate;
    private LocalDate returnDate;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private String flightNumber;
    private int distance;
    @DateTimeFormat(pattern = "HH:mm")
    private Duration flightDuration;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(String flightClass) {
        this.flightClass = flightClass;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getFlightDuration() {
        return String.format("%d:%02d%n", flightDuration.between(departureTime,arrivalTime).toHoursPart(),Duration.between(departureTime,arrivalTime).toMinutesPart());

    }

    /*public Duration getFlightDuration() {
        return flightDuration;
    }*/

    public void setFlightDuration(Duration flightDuration) {
        this.flightDuration = flightDuration;
    }

}

