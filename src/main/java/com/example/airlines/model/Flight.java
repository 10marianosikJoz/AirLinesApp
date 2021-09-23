package com.example.airlines.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Entity
public class Flight {

    @Id
    @SequenceGenerator(
            name = "flight_sequence",
            sequenceName = "flight_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "flight_sequence"
    )
    private Long id;
    @Column(name = "from_place")
    private String from;
    private String destination;
    @Column(name = "flight_class")
    private String flightClass;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "departure_date")
    private LocalDate departureDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "return_date")
    private LocalDate returnDate;
    @Column(name = "departure_time")
    private LocalTime departureTime;
    @Column(name = "arrival_time")
    private LocalTime arrivalTime;
    @Column(name = "flight_number")
    private String flightNumber;
    @Column(name = "flight_distance")
    private int flightDistance;
    @Column(name = "flight_duration")
    @DateTimeFormat(pattern = "HH:mm")
    private Duration flightDuration;

    @OneToMany(mappedBy = "flight")
    private Set<Ticket> tickets;


    public Flight() {
    }

    public Flight(
            String from,
            String destination,
            String flightClass,
            LocalDate departureDate,
            LocalDate returnDate,
            LocalTime departureTime,
            LocalTime arrivalTime,
            String flightNumber,
            int flightDistance,
            Duration flightDuration) {
        this.from = from;
        this.destination = destination;
        this.flightClass = flightClass;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.flightNumber = flightNumber;
        this.flightDistance = flightDistance;
        this.flightDuration = flightDuration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
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

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public int getFlightDistance() {
        return flightDistance;
    }

    public void setFlightDistance(int flightDistance) {
        this.flightDistance = flightDistance;
    }

    public String getFlightDuration() {
        return String.format("%d:%02d%n", flightDuration.between(departureTime,arrivalTime).toHoursPart(),Duration.between(departureTime,arrivalTime).toMinutesPart());

    }

    public void setFlightDuration(Duration flightDuration) {
        this.flightDuration = flightDuration;
    }
}
