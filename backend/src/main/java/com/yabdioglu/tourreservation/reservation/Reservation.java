package com.yabdioglu.tourreservation.reservation;

import com.yabdioglu.tourreservation.tour.Tour;
import com.yabdioglu.tourreservation.user.User;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "reservations")
@Data
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "select_date")
    private LocalDate selectDate;

    @Column(name = "adult")
    private int adult;

    @Column(name = "child")
    private int child;

    @Column(name = "hotel_name")
    private String hotelName;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @Column(name = "cancelled", columnDefinition = "boolean default false")
    private boolean cancelled;

    @Transient
    private boolean refundActive;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "tour_id")
    private Tour tour;

    @Column(name = "date_created")
    @CreationTimestamp
    private Date dateCreated;

    @Column(name = "last_updated")
    @UpdateTimestamp
    private Date lastUpdated;

    public boolean isRefundActive() {
        LocalDate localDate = LocalDate.now();
        if(localDate.isBefore(selectDate))
            return true;
        return false;
    }

}
