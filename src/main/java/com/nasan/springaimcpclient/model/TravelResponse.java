package com.nasan.springaimcpclient.model;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.util.List;

public class TravelResponse {
    
    @JsonPropertyDescription("Destination city name")
    private String destinationCity;
    
    @JsonPropertyDescription("Travel date in YYYY-MM-DD format")
    private String travelDate;
    
    @JsonPropertyDescription("List of available flights to the destination")
    private List<Flight> availableFlights;
    
    @JsonPropertyDescription("List of available hotels in the destination")
    private List<Hotel> availableHotels;
    
    @JsonPropertyDescription("Search timestamp when the search was performed")
    private String searchTimestamp;
    
    @JsonPropertyDescription("Total number of flights found")
    private Integer totalFlights;
    
    @JsonPropertyDescription("Total number of hotels found")
    private Integer totalHotels;
    
    @JsonPropertyDescription("Search status (success, partial, failed)")
    private String searchStatus;
    
    @JsonPropertyDescription("Additional search notes or warnings")
    private String searchNotes;
    
    @JsonPropertyDescription("Currency used for prices (default: USD)")
    private String currency;

    // Constructors
    public TravelResponse() {}

    public TravelResponse(String destinationCity, String travelDate, List<Flight> availableFlights, 
                         List<Hotel> availableHotels, String searchTimestamp, Integer totalFlights, 
                         Integer totalHotels, String searchStatus, String searchNotes, String currency) {
        this.destinationCity = destinationCity;
        this.travelDate = travelDate;
        this.availableFlights = availableFlights;
        this.availableHotels = availableHotels;
        this.searchTimestamp = searchTimestamp;
        this.totalFlights = totalFlights;
        this.totalHotels = totalHotels;
        this.searchStatus = searchStatus;
        this.searchNotes = searchNotes;
        this.currency = currency;
    }

    // Getters and Setters
    public String getDestinationCity() { return destinationCity; }
    public void setDestinationCity(String destinationCity) { this.destinationCity = destinationCity; }

    public String getTravelDate() { return travelDate; }
    public void setTravelDate(String travelDate) { this.travelDate = travelDate; }

    public List<Flight> getAvailableFlights() { return availableFlights; }
    public void setAvailableFlights(List<Flight> availableFlights) { this.availableFlights = availableFlights; }

    public List<Hotel> getAvailableHotels() { return availableHotels; }
    public void setAvailableHotels(List<Hotel> availableHotels) { this.availableHotels = availableHotels; }

    public String getSearchTimestamp() { return searchTimestamp; }
    public void setSearchTimestamp(String searchTimestamp) { this.searchTimestamp = searchTimestamp; }

    public Integer getTotalFlights() { return totalFlights; }
    public void setTotalFlights(Integer totalFlights) { this.totalFlights = totalFlights; }

    public Integer getTotalHotels() { return totalHotels; }
    public void setTotalHotels(Integer totalHotels) { this.totalHotels = totalHotels; }

    public String getSearchStatus() { return searchStatus; }
    public void setSearchStatus(String searchStatus) { this.searchStatus = searchStatus; }

    public String getSearchNotes() { return searchNotes; }
    public void setSearchNotes(String searchNotes) { this.searchNotes = searchNotes; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }
}
