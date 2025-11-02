package com.nasan.springaimcpclient.model;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class Flight {
    
    @JsonPropertyDescription("Flight number or code")
    private String flightNumber;
    
    @JsonPropertyDescription("Airline company name")
    private String airline;
    
    @JsonPropertyDescription("Departure airport code (e.g., IST)")
    private String departureAirport;
    
    @JsonPropertyDescription("Arrival airport code (e.g., CDG)")
    private String arrivalAirport;
    
    @JsonPropertyDescription("Departure date and time in ISO format")
    private String departureTime;
    
    @JsonPropertyDescription("Arrival date and time in ISO format")
    private String arrivalTime;
    
    @JsonPropertyDescription("Flight price in USD")
    private Double price;
    
    @JsonPropertyDescription("Available seat count")
    private Integer availableSeats;
    
    @JsonPropertyDescription("Flight duration in hours")
    private String duration;
    
    @JsonPropertyDescription("Aircraft type (e.g., Boeing 737)")
    private String aircraftType;

    // Constructors
    public Flight() {}

    public Flight(String flightNumber, String airline, String departureAirport, String arrivalAirport, 
                  String departureTime, String arrivalTime, Double price, Integer availableSeats, 
                  String duration, String aircraftType) {
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
        this.availableSeats = availableSeats;
        this.duration = duration;
        this.aircraftType = aircraftType;
    }

    // Getters and Setters
    public String getFlightNumber() { return flightNumber; }
    public void setFlightNumber(String flightNumber) { this.flightNumber = flightNumber; }

    public String getAirline() { return airline; }
    public void setAirline(String airline) { this.airline = airline; }

    public String getDepartureAirport() { return departureAirport; }
    public void setDepartureAirport(String departureAirport) { this.departureAirport = departureAirport; }

    public String getArrivalAirport() { return arrivalAirport; }
    public void setArrivalAirport(String arrivalAirport) { this.arrivalAirport = arrivalAirport; }

    public String getDepartureTime() { return departureTime; }
    public void setDepartureTime(String departureTime) { this.departureTime = departureTime; }

    public String getArrivalTime() { return arrivalTime; }
    public void setArrivalTime(String arrivalTime) { this.arrivalTime = arrivalTime; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public Integer getAvailableSeats() { return availableSeats; }
    public void setAvailableSeats(Integer availableSeats) { this.availableSeats = availableSeats; }

    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }

    public String getAircraftType() { return aircraftType; }
    public void setAircraftType(String aircraftType) { this.aircraftType = aircraftType; }
}
