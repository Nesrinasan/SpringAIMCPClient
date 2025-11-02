package com.nasan.springaimcpclient.model;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class Hotel {
    
    @JsonPropertyDescription("Hotel name")
    private String hotelName;
    
    @JsonPropertyDescription("Hotel star rating (1-5)")
    private Integer starRating;
    
    @JsonPropertyDescription("Hotel address")
    private String address;
    
    @JsonPropertyDescription("Distance to city center in kilometers")
    private Double distanceToCenter;
    
    @JsonPropertyDescription("Price per night in USD")
    private Double pricePerNight;
    
    @JsonPropertyDescription("Available room count")
    private Integer availableRooms;
    
    @JsonPropertyDescription("Room type (e.g., Standard, Deluxe, Suite)")
    private String roomType;
    
    @JsonPropertyDescription("Hotel amenities (WiFi, Pool, Gym, etc.)")
    private String amenities;
    
    @JsonPropertyDescription("Guest review rating (1-10)")
    private Double reviewRating;
    
    @JsonPropertyDescription("Hotel image URL")
    private String imageUrl;
    
    @JsonPropertyDescription("Breakfast included (true/false)")
    private Boolean breakfastIncluded;

    // Constructors
    public Hotel() {}

    public Hotel(String hotelName, Integer starRating, String address, Double distanceToCenter, 
                 Double pricePerNight, Integer availableRooms, String roomType, String amenities, 
                 Double reviewRating, String imageUrl, Boolean breakfastIncluded) {
        this.hotelName = hotelName;
        this.starRating = starRating;
        this.address = address;
        this.distanceToCenter = distanceToCenter;
        this.pricePerNight = pricePerNight;
        this.availableRooms = availableRooms;
        this.roomType = roomType;
        this.amenities = amenities;
        this.reviewRating = reviewRating;
        this.imageUrl = imageUrl;
        this.breakfastIncluded = breakfastIncluded;
    }

    // Getters and Setters
    public String getHotelName() { return hotelName; }
    public void setHotelName(String hotelName) { this.hotelName = hotelName; }

    public Integer getStarRating() { return starRating; }
    public void setStarRating(Integer starRating) { this.starRating = starRating; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public Double getDistanceToCenter() { return distanceToCenter; }
    public void setDistanceToCenter(Double distanceToCenter) { this.distanceToCenter = distanceToCenter; }

    public Double getPricePerNight() { return pricePerNight; }
    public void setPricePerNight(Double pricePerNight) { this.pricePerNight = pricePerNight; }

    public Integer getAvailableRooms() { return availableRooms; }
    public void setAvailableRooms(Integer availableRooms) { this.availableRooms = availableRooms; }

    public String getRoomType() { return roomType; }
    public void setRoomType(String roomType) { this.roomType = roomType; }

    public String getAmenities() { return amenities; }
    public void setAmenities(String amenities) { this.amenities = amenities; }

    public Double getReviewRating() { return reviewRating; }
    public void setReviewRating(Double reviewRating) { this.reviewRating = reviewRating; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public Boolean getBreakfastIncluded() { return breakfastIncluded; }
    public void setBreakfastIncluded(Boolean breakfastIncluded) { this.breakfastIncluded = breakfastIncluded; }
}
