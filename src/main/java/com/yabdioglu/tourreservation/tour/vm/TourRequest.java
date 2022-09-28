package com.yabdioglu.tourreservation.tour.vm;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TourRequest {

    private String title;

    private String description;

    private BigDecimal priceForAdult;

    private BigDecimal priceForChild;

    private int quota;

}
