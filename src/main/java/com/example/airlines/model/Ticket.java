package com.example.airlines.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @SequenceGenerator(
            name = "ticket_sequence",
            sequenceName = "ticket_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "ticket_sequence"
    )
    private Long id;
    @Column(name = "ticket_number")
    private String ticketNumber;
    private BigDecimal price;
    private String seat;
    private String gate;
    @Column(name = "baggage_weight")
    private double baggageWeight;
    @Column(name = "departure_terminal")
    private String departureTerminal;
    @Column(name = "arrival_terminal")
    private String arrivalTerminal;
    @Column(name = "take_off_airport")
    private String takeOffAirPort;
    @Column(name = "final_airport")
    private String finalAirPort;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "user_id"
    )
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(
            name = "flight_id"
    )
    private Flight flight;

    public Ticket() {
    }

    public Ticket(String ticketNumber,
                  BigDecimal price,
                  String seat,
                  String gate,
                  double baggageWeight,
                  String departureTerminal,
                  String arrivalTerminal,
                  String takeOffAirPort,
                  String finalAirPort,
                  Flight flight
    ) {
        this.ticketNumber = ticketNumber;
        this.price = price;
        this.seat = seat;
        this.gate = gate;
        this.baggageWeight = baggageWeight;
        this.departureTerminal = departureTerminal;
        this.arrivalTerminal = arrivalTerminal;
        this.takeOffAirPort = takeOffAirPort;
        this.finalAirPort = finalAirPort;
        this.flight = flight;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public double getBaggageWeight() {
        return baggageWeight;
    }

    public void setBaggageWeight(double baggageWeight) {
        this.baggageWeight = baggageWeight;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public String getDepartureTerminal() {
        return departureTerminal;
    }

    public void setDepartureTerminal(String departureTerminal) {
        this.departureTerminal = departureTerminal;
    }

    public String getTakeOffAirPort() {
        return takeOffAirPort;
    }

    public void setTakeOffAirPort(String takeOffAirPort) {
        this.takeOffAirPort = takeOffAirPort;
    }

    public String getFinalAirPort() {
        return finalAirPort;
    }

    public void setFinalAirPort(String finalAirPort) {
        this.finalAirPort = finalAirPort;
    }

    public String getArrivalTerminal() {
        return arrivalTerminal;
    }

    public void setArrivalTerminal(String arrivalTerminal) {
        this.arrivalTerminal = arrivalTerminal;
    }
}
