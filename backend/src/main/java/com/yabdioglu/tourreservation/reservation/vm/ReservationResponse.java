package com.yabdioglu.tourreservation.reservation.vm;

import com.yabdioglu.tourreservation.reservation.Reservation;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Data
public class ReservationResponse {

    private Long id;

    private Long userId;

    private Long tourId;

    private LocalDate selectDate;

    private int adult;

    private int child;

    private String hotelName;

    private BigDecimal totalPrice;

    private boolean cancelled;

    private boolean refundActive;

    private Date dateCreated;

    public ReservationResponse(Reservation reservation) {
        this.id = reservation.getId();
        this.userId = reservation.getUser().getId();
        this.tourId = reservation.getTour().getId();
        this.selectDate = reservation.getSelectDate();
        this.adult = reservation.getAdult();
        this.child = reservation.getChild();
        this.hotelName = reservation.getHotelName();
        this.totalPrice = reservation.getTotalPrice();
        this.cancelled = reservation.isCancelled();
        this.refundActive = reservation.isRefundActive();
        this.dateCreated = reservation.getDateCreated();
    }
}
