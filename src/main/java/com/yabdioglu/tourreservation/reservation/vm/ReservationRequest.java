package com.yabdioglu.tourreservation.reservation.vm;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Data
public class ReservationRequest {

    private Long userId;

    private Long tourId;

    private LocalDate selectDate;

    private int adult;

    private int child;

    private BigDecimal totalPrice;

    private String hotelName;


}
